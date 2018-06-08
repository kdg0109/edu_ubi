package com.ubivelox.factorial;

import java.math.BigInteger;
import java.util.ArrayList;

import com.ubivelox.exception.UbiveloxException;

public class Factorial
{

    static class Factor
    {
        long number;
        long exponentiation;





        public Factor(final long number, final long exponentiation)
        {
            this.number = number;
            this.exponentiation = exponentiation;
        }





        public long getNumber()
        {
            return this.number;
        }





        public void setNumber(final long number)
        {
            this.number = number;
        }





        public long getExponentiation()
        {
            return this.exponentiation;
        }





        public void setExponentiation(final long exponentiation)
        {
            this.exponentiation = exponentiation;
        }

    }





    public static long getZeroCount(final long numOrg, final int jinsu) throws UbiveloxException
    {
        // return getCount(numOrg, parser5(numOrg, jinsu));
        return getCount(numOrg, parser5(numOrg, jinsu));
    }





    private static ArrayList<Factor> parser5(final long numOrg, final int jinsu) throws UbiveloxException
    {
        ArrayList<Factor> list = new ArrayList<>();
        int n = 2;
        long number = jinsu;
        long count = 0;

        if ( jinsu == 1 || jinsu == 0 || jinsu < 0 )
        {
            throw new UbiveloxException("에러 : 값 1 또는 0 또는 음수");
        }
        do
        {
            if ( number % n == 0 )
            {
                while ( number % n == 0 )
                {

                    number /= n;
                    count++;
                }

                System.out.println("n : " + n + " count : " + count);
                list.add(new Factor(n, count));
            }
            n++;
            count = 0;

        }
        while ( n != jinsu );

        if ( list.isEmpty() )
        {
            list.add(new Factor(jinsu, 1));
        }

        return list;
    }

    // 1. jinsu의 최소공약수를 구함. 2,3,5,7,11,13 이런거 생기겠지 제곱도 생기고 22 31
    // 2. num을 구해진 jinsu의 최소공약수 나누고 그때나온 몫들을 제곱으로 나눠. 그렇게 나온 수들이 최소공약수 갯수대로 나와
    // 3. 2번에서 구한 값들의 최소 값이 0의 갯수임





    // num는 숫자임
    static long getCount(final long numOrg, final ArrayList<Factor> factoList) throws UbiveloxException
    {
        long minZeroCount = Long.MAX_VALUE;

        for ( int i = 0; i < factoList.size(); i++ )
        {
            long num = numOrg;
            long minZeroCountTmp = 0;
            long numResult = 0;
            long expResult = 0;

            if ( numOrg < 0 )
            {
                throw new UbiveloxException("에러 : 음수");
            }
            do
            {
                num /= factoList.get(i).number;
                numResult += num;
            }
            while ( num != 1 && num != 0 );

            expResult = numResult;

            if ( factoList.get(i).exponentiation != 1 )
            {
                while ( numResult % factoList.get(i).exponentiation == 0 )
                {
                    minZeroCountTmp++;
                    numResult /= factoList.get(i).exponentiation;
                }
                expResult = minZeroCountTmp;
            }

            minZeroCountTmp = expResult;

            if ( minZeroCount > minZeroCountTmp )
            {
                minZeroCount = minZeroCountTmp;
            }
        }

        return minZeroCount;

    }





    // 5를 몇 개 곱하느냐에 따라 0의 갯수도 늘어남. 따라서 5배수만 활용.
    // for문에서는 값을 5로 계속 쪼갰을 때의 5 갯수를 count
    public static long getZeroCount0(final long numOrg) throws UbiveloxException
    {
        long count = 0;
        long num;

        if ( numOrg < 0 )
        {
            throw new UbiveloxException("에러 : 음수");
        }

        // i가 5의 배수일 때만 검색
        for ( long i = 5; i <= numOrg && i > 0; i += 5 )
        {
            num = i;

            // 5의 배수 i를 5로 계속 쪼갰을 때의 5 갯수를 count한다.
            do
            {
                count += 1;
                num /= 5;
            }
            while ( num % 5 == 0 );

        }

        return count;
    }





    public static long getZeroCount3(final long numOrg) throws UbiveloxException
    {
        long count = 0;
        long num = numOrg;

        if ( numOrg < 0 )
        {
            throw new UbiveloxException("에러 : 음수");
        }

        do
        {
            count += num / 5;
            num /= 5;
        }
        while ( num != 0 );

        return count;
    }





    static long getZeroCount4(final long numOrg, final long jinsu) throws UbiveloxException
    {
        long factor1 = 2;
        long factor2 = 2;

        if ( numOrg < 0 )
        {
            throw new UbiveloxException("에러 : 음수");
        }
        else if ( jinsu == 0 )
        {
            throw new UbiveloxException("에러 : 옳지 않은 진수");
        }
        else if ( jinsu == 1 )
        {
            return 0;
        }

        // 진수의 최소 공약수 하나랑 그에 먹는 약수
        while ( jinsu % factor1 != 0 )
        {
            factor1++;
        }

        factor2 = (jinsu / factor1 < factor1 ? factor1 : jinsu / factor1);

        System.out.println(factor1 + "/" + factor2);

        long num = numOrg;
        long count = 0;

        do
        {
            count += num / factor2;
            num /= factor2;

        }
        while ( num != 0 );

        return count;
    }





    // 곱하고 10으로 나눴을 때 나머지가 0이라면 곱한 결과 값이 10배수니까 count올리고 /10을 하여 다시 0이 없는 값으로 변경시킨다.
    // 만약 result가 190라면 count++해주고 19로 만들어줌
    public static int getZeroCount1(final int numOrg) throws UbiveloxException
    {
        int count = 0;
        double result = 1;

        if ( numOrg < 0 )
        {
            throw new UbiveloxException("에러 : 음수");
        }

        for ( int i = 1; i <= numOrg; i++ )
        {
            result *= i;
            while ( result % 10 == 0 )
            {
                count++;
                result /= 10;
            }
        }

        return count;
    }





    // BigInteger를 이용하여 getZeroCount1를 보완
    public static int getZeroCount2(final int numOrg) throws UbiveloxException
    {
        int count = 0;
        BigInteger result = BigInteger.valueOf(1);
        BigInteger ten = BigInteger.valueOf(10);
        BigInteger zero = BigInteger.valueOf(0);

        if ( numOrg < 0 )
        {
            throw new UbiveloxException("에러 : 음수");
        }

        for ( int i = 1; i <= numOrg; i++ )
        {
            result = result.multiply(BigInteger.valueOf(i));

            while ( result.mod(ten)
                          .equals(zero) )
            {
                count++;
                result = result.divide(ten);
            }
        }

        return count;
    }
}
