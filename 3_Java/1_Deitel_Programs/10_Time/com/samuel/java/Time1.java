//p. 185 Time1.java

package com.samuel.java;

public class Time1
{
    private int hour; // 0 - 23
    private int minute; // 0 - 59
    private int second; // 0 - 59

    //set a new time value using universal time;
    
    public void setTime( int h, int m, int s)
    {
        minute = ( ( m >= 0 && m < 60 ) ? m : 0); //validate minute
        second = ( ( s >=0 && s < 60 ) ? s : 0); // validate second
        hour = ( ( h >= 0 && h < 24 ) ? h : 0);

    }// end method setTime
    
    public String toUniversalString()
    {
        return String.format ("%02d:%02d:%02d", hour, minute, second);
    }// end method toUniversalString
    
    //convert to String in universal-time format (HH:MM:SS AM or PM)
    public String toString()
    {
        return String.format("%d:%02d:%02d %s", ( ( hour == 0 || hour == 12 ) ? 12 : hour % 12 ), minute, second, ( hour < 12 ? "AM" : "PM" ) );
    } //end method toString
    
}
