/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.home.hextodec;
import java.util.regex.*;
/**
 *
 * @author PC
 */
public class HexToDec 
{

    public static void main(String[] args) throws Exception
    {
        final long MAX_INT = 2L * Integer.MAX_VALUE + 1L;
        var nDecNum = 0L;
        var nHexPower = 1L;
        var console = System.console();
        var nMaxHexLen = Math.ceil(Math.log(MAX_INT) / Math.log(16));
        var oRegExpr = Pattern.compile("^[0-9A-Fa-f]+$");
        System.out.println("Input a hexadecimal number");
        var strLine = console.readLine();
        var nStrLen = strLine.length();
        var oMatcher = oRegExpr.matcher(strLine);
        var bIsMatch = oMatcher.matches();
        var bRightString = (nStrLen <= nMaxHexLen) && (bIsMatch);
        if(!bRightString)
        {
            System.out.println("Wrong hexadecimal number format!!!");
            System.exit(0);
        }
        for (int i = 0; i < nStrLen; i++)
        {
            int nHexDigit = 0;
            char chHexDigit = strLine.charAt(nStrLen - 1 - i);
            if(chHexDigit >= '0' && chHexDigit <= '9')
              nHexDigit = chHexDigit - '0';
            else if (chHexDigit >= 'A' && chHexDigit <= 'F')
              nHexDigit = 10 + chHexDigit - 'A';
            else if (chHexDigit >= 'a' && chHexDigit <='f')
              nHexDigit = 10 + chHexDigit - 'a';
            nDecNum += (nHexDigit * nHexPower);
            nHexPower *= 16;
        }
        System.out.printf
        (
            "The decimal equivalent of the hexadecimal number %s is %d\r\n",
            strLine, nDecNum
        );
    }
}