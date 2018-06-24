package tlvparser;

import java.util.ArrayList;

import lombok.Data;

@Data
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

}
