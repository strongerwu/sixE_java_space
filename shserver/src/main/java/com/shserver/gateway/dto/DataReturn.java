package com.shserver.gateway.dto;

public class DataReturn
{
  private int code;
  private String message;
  private Object data;
  
  
  public Object getData ( )
  {
    return data;
  }
  public void setData ( Object data )
  {
    this.data = data;
  }
  public String getMessage ( )
  {
    return message;
  }
  public void setMessage ( String message )
  {
    this.message = message;
  }
  public int getCode ( )
  {
    return code;
  }
  public void setCode ( int code )
  {
    this.code = code;
  }

  
}
