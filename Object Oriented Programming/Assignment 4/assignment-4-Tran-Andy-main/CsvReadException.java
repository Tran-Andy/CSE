public class CsvReadException extends Exception{
    private String data;


    public CsvReadException(String input){
        super(input);
        this.data = input;
    }

    @Override
    public String toString(){
        return "CsvReadException:" + data;
    }
}
