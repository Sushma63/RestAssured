package dataProvider;

public class general {




    public StringBuilder constructURL (String url, String testdata)
    {
        String endpoint =url;
        String test=testdata;

        StringBuilder api=new StringBuilder(endpoint);
        int s= api.indexOf("{");
        int end=api.indexOf("}");
        StringBuilder value=api.replace(s,end+1,test);
        System.out.println(value);
        return value;

    }
}
