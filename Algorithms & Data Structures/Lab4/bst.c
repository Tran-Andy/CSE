#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "bst.h"


link z,head;
Item NULLitem=(-9999999);
Item item;
int keyNumber, dupe, insertion;
int live = 0; int dead = 0; int recycle = 0; int height = 0; int build = 0; int cycle = 0;
struct STnode* temp;
struct STnode* rebuild, recycling, headLive, headRecycle;


link NEW(Item item, link l, link r, char tombstone, int N)
// Allocates and fills in a node
{
    link x = malloc(sizeof *x); 
    x->item = item;
    x->l = l;
    x->r = r;
    x->tombstone = tombstone;
    x->N = N;
    return x;
}

void STinit()
{
    head = (z = NEW(NULLitem, NULL, NULL, '0' , 0));
    // head->tombstone=1;
}


struct STnode* insert(struct STnode* root, Item item)
{
    struct STnode* insertNode = NULL;
    insertNode = NEW(item,z,z,'0',1);
    if(head == z)
    {   
         head = insertNode;
         live += 1;
         return root;
    }
    if(root != z)
    {   
        if (item == root->item)
        {   
            if(root->tombstone == '1')
            {   
                root->tombstone = '0';
                insertion = 1;
                live += 1;
                dead -= 1;
                root->N = root->N + 1;
            }
            else
            {
                dupe = 1;
                return z;
            }
        }
        else if(item < root->item)
        {
            root->l = insert(root->l, item);
            if(dupe == 0)
            {
                insertion = 1;
                root->N = root->N + 1;
            }
        }
        else if(item > root->item)
        {
            root->r = insert(root->r, item);
            if(dupe == 0)
            {
                insertion = 1;
                root->N = root->N + 1;
            }
        }
    }
    if(insertion == 1)
    {
        return root;
    }
    else
    {   
        live += 1;
        return insertNode;
    }
}

void STinsert(Item item)
{      
    dupe = 0;
    insertion = 0;
    insert(head,item);

}

void deleteNode(struct STnode* root, Key v)
{   
    if(v < root->item)
    {
        deleteNode(root->l, v);
        root->N = root->N - 1;
        // live += 1;
    }
    else if(v > root->item)
    {
        deleteNode(root->r, v);
        root->N = root->N - 1;
        // live += 1;
    }
    else if(v == root->item)
    {
        root->tombstone = '1';
        root->N = root->N - 1;
        live -= 1;
        dead += 1;
    }
}
void STdelete(Key v)
{   
    deleteNode(head,v);
}


Item searchR(link h, Key v)
// Recursive search for a key
{ 
    Key t = key(h->item);
    if (h == z) 
        return NULLitem;
    if (eq(v, t))
        return h->item;
    if (less(v, t))
        return searchR(h->l, v);
    return searchR(h->r, v);
}

Item STsearch(Key v) 
{
    return searchR(head, v);
}

int invSelectR(link h, Key v)
// Inverse of selectR
{
Key t = key(h->item);
int work;

    if (h==z)
    return -1;  // v doesn't appear as a key
    if (eq(v, t))
    {
        if(h->tombstone == '0')
        {
            return h->l->N+1;
        }
        else
        {
            return -1;
        }
    }
    if (less(v, t))
    return invSelectR(h->l,v);
    work=invSelectR(h->r,v);
    if (work==(-1))
    return -1;  // v doesn't appear as a key
    return 1 + h->l->N + work;
}

int STinvSelect(Key v)
{
    return invSelectR(head,v);
}

Item selectR(link h, int i)
// Returns the ith smallest key where i=1 returns the smallest
// key.  Thus, this is like flattening the tree inorder into an array
// and applying i as a subscript.
{ 
    if(keyNumber == 0)
    {
        h = head;
        keyNumber = 1;
    }
    int r = h->l->N+1;
        if (h == z)
        {
            keyNumber = 0;
            printf("Impossible situation in selectR\n");
            STprintTree();
            exit(0);
        }
        if (i==r)
        {
            keyNumber = 0;
            return h->item;
        }
        if (i<r) 
        {
            return selectR(h->l, i);
        }
        else
        {
            if(h->tombstone == '0')
            {
                return selectR(h->r, i-r);
            }
            else 
            {
                return selectR(h->r, i-r-1);
            }
        }
}

Item STselect(int k)
{
    if (k<1 || k>head->N)
    {
        printf("Range error in STselect() k %d N %d\n",k,head->N);
        exit(0);
    }
    return selectR(head, k);
}

int getDead()
{
    return dead;
}

int getLive()
{
    return live;
}

int getRecycled()
{
    return recycle;
}
int heightCount(link node)
{   
    int l, r;
    if(node == z) return 0;
    l = heightCount(node->l); r = heightCount(node->r);
    if (l > r) return l+1; else return r+1;
}
int getHeight()
{

    return heightCount(head);
}

int verification(link node)
{   
    if(node == z)
    return 1;
    int l = verification(node->l);
    if(item >= node->item)
    return 0;
    if(node->tombstone == '0' && (node->N != node->l->N + node->r->N + 1))
    return 0;
    if(node->tombstone == '1' && (node->N != node->l->N + node->r->N))
    return 0;

    item = node->item;
    int r = verification(node->r);
    return l > r ? r : l;
}   

int verifyBSTproperties()
{
    item = NULLitem;
    return verification(head);
}


void nodeCollection(link node)
{
    if(node == z)
    {
        return;
    }
    nodeCollection(node->l);
    if(build == 0)
    {   
        if(node->tombstone == '0')
        {
           
        }
    }
    
}



void rebuildTree()
{   

}
void removeDead()
{
    
}




link load(int count)
{ // Linear-time inorder loading of BST from file
    int leftCount,rightCount;
    link work,left;

    if (count==0)
        return z;

    leftCount=count/2;
    rightCount=count-leftCount-1;

    left=load(leftCount);
    work=(link) malloc(sizeof(struct STnode));
    work->l=left;
    work->r=load(rightCount);
    work->N = work->l->N + work->r->N + 1;
    return work;
}

void printTree(link h, int level)
{ // Print indented tree from right-to-left
    int i;

    if (h == z)
    {
    // for (i=0;i<level;i++)
    //     printf("   ");
    //     // printf(".\n");
        return;
    }
    printTree(h->r,level+1);
    for (i=0;i<level;i++)
    printf("   ");
    if(h->tombstone == '1')
    {
        printf("(%d) %d\n", h->item, h->N);
    }
    else {printf("%d %d\n",h->item, h->N);}
    printTree(h->l,level+1);

}

void STprintTree()
{   
    return printTree(head, 0);
}