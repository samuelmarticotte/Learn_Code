//Buffer.java


public interface Buffer
{
    //place int value from buffer
    public void set( int value ) throws InterruptedException;
    
    //return int value from Buffer
    public int get() throws InterruptedException;

}// end Interface Buffer
