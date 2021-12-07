package com.epam.rd.autotasks;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;
    public Battleship8x8(final long ships) {
        this.ships = ships;
    }
    public boolean shoot(String shot) {
        boolean aimed = false;
        String s=Long.toBinaryString(this.ships);
        if(s.length()==63)
        {
            s=String.valueOf(new StringBuffer(s).insert(0,"0"));
        }

        String []shootMap=s.split("");
        String []cr=shot.split("");
        List<String>ab=List.of("A","B","C","D","E","F","G","H");
        int shotIndex=ab.indexOf(cr[0]);
        int index=8*(Integer.parseInt(cr[1])-1)+shotIndex;
        this.shots|=1L<<63-index;

        return Objects.equals(shootMap[index],"1");
    }
    public String state () {
        String b=Long.toBinaryString(this.ships);
        if(ships>0)
        {
            b="0"+b;
        }
        String s1=Long.toBinaryString(shots);
        System.out.println(s1.length());
        if(s1.length()<64)
        {
            int c=64-s1.length();
            for(int i=0;i<c;i++)
            {
                s1="0"+s1;
            }
        }

        System.out.println(s1.length());
        char []arr1=b.toCharArray();
        char []arr=s1.toCharArray();
        for(int i=0;i<arr1.length;i++)
        {
            if(arr1[i]=='1'&&arr[i]=='1')
            {
                arr[i]='☒';
            }else if (arr1[i]=='0'&&arr[i]=='1')
            {
                arr[i]='×';
            }else if(arr1[i]=='1'&&arr[i]=='0')
            {
                arr[i]='☐';
            }else if(arr1[i]=='0'&&arr[i]=='0')
                arr[i]='.';
        }

        String s="";
        for(int i=0;i<arr.length;i++)
        {
            s=s+arr[i];
        }
        String []t=new String[8];
        for(int i=0;i<s.length()/8;i++)
        {
            t[i]=s.substring(i*8,i*8+8);
        }
        String m="";
        for(int i=0;i<t.length;i++)
        {
            m=m+t[i]+"\n";
        }
        System.out.println(m);
        return m;
    }
}
