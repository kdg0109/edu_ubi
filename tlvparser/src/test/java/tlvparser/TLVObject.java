package tlvparser;

import java.util.ArrayList;

public class TLVObject
{
    String               tag;
    String               length;
    ArrayList<TLVObject> value;
    String               stringValue;





    public TLVObject(final String tag, final String length)
    {
        this.tag = tag;
        this.length = length;
        this.stringValue = "";
    }





    public TLVObject(final String tag, final String length, final String stringValue)
    {
        this.tag = tag;
        this.length = length;
        this.stringValue = stringValue;
    }





    public TLVObject(final String tag, final String length, final ArrayList<TLVObject> arrayList)
    {
        this.tag = tag;
        this.length = length;
        this.value = arrayList;
    }





    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.length == null) ? 0 : this.length.hashCode());
        result = prime * result + ((this.stringValue == null) ? 0 : this.stringValue.hashCode());
        result = prime * result + ((this.tag == null) ? 0 : this.tag.hashCode());
        result = prime * result + ((this.value == null) ? 0 : this.value.hashCode());
        return result;
    }





    @Override
    public boolean equals(final Object obj)
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }
        if ( getClass() != obj.getClass() )
        {
            return false;
        }
        TLVObject other = (TLVObject) obj;
        if ( this.length == null )
        {
            if ( other.length != null )
            {
                return false;
            }
        }
        else if ( !this.length.equals(other.length) )
        {
            return false;
        }
        if ( this.stringValue == null )
        {
            if ( other.stringValue != null )
            {
                return false;
            }
        }
        else if ( !this.stringValue.equals(other.stringValue) )
        {
            return false;
        }
        if ( this.tag == null )
        {
            if ( other.tag != null )
            {
                return false;
            }
        }
        else if ( !this.tag.equals(other.tag) )
        {
            return false;
        }
        if ( this.value == null )
        {
            if ( other.value != null )
            {
                return false;
            }
        }
        else if ( !this.value.equals(other.value) )
        {
            return false;
        }
        return true;
    }





    public String getTag()
    {
        return this.tag;
    }





    public void setTag(final String tag)
    {
        this.tag = tag;
    }





    public String getLength()
    {
        return this.length;
    }





    public void setLength(final String length)
    {
        this.length = length;
    }





    public void setStringValue(final String stringValue)
    {
        this.stringValue = stringValue;
    }





    public String getStringValue()
    {
        return this.stringValue;
    }





    public ArrayList<TLVObject> getValue()
    {
        return this.value;
    }





    public void setValue(final ArrayList<TLVObject> value)
    {
        this.value = value;
    }

}