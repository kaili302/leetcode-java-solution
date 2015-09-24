public int compareVersion(String version1, String version2) {
    String[] v1=version1.split("\\.");
    String[] v2=version2.split("\\.");
    if(v1.length*v2.length==0) 
    {
        if(v1.length==0) return v2.length==0?0: -1;
        else return 1;
    }
    int v1l=Integer.parseInt(v1[0]), v1r=0, v2l=Integer.parseInt(v2[0]), v2r=0;
    if(v1l!=v2l) return v1l>v2l?1:-1;
    else {
        v1r=(v1.length==1)?0:Integer.parseInt(v1[1]);
        v2r=(v2.length==1)?0:Integer.parseInt(v2[1]);
        return v1r==v2r?0:(v1r>v2r?1:-1);
    }
}
/*
Compare two version numbers version1 and version2. 
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character. 
The . character does not represent a decimal point and is used to separate number sequences.
Here is an example of version numbers ordering:
0.1 < 1.1 < 1.2 < 13.37
*/