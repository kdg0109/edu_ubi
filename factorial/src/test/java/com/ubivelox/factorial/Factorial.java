package com.ubivelox.factorial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.ubivelox.exception.UbiveloxException;

public class Factorial
{

    static class Factor
    {
        private long number;         // 최소 공약수
        private long exponentiation; // 거듭 제곱





        public Factor(final long number, final long exponentiation)
        {
            this.number = number;
            this.exponentiation = exponentiation;
        }





        public long getNumber() throws UbiveloxException
        {
            if ( this.number == 0 )
            {
                throw new UbiveloxException("에러 : number가 0 입니다.");
            }
            return this.number;
        }





        public void setNumber(final long number)
        {
            this.number = number;
        }





        public long getExponentiation() throws UbiveloxException
        {
            if ( this.exponentiation == 0 )
            {
                throw new UbiveloxException("에러 : exponentiation가 0 입니다.");
            }
            return this.exponentiation;
        }





        public void setExponentiation(final long exponentiation)
        {
            this.exponentiation = exponentiation;
        }





        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + (int) (this.exponentiation ^ (this.exponentiation >>> 32));
            result = prime * result + (int) (this.number ^ (this.number >>> 32));
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
            Factor other = (Factor) obj;
            if ( this.exponentiation != other.exponentiation )
            {
                return false;
            }
            if ( this.number != other.number )
            {
                return false;
            }
            return true;
        }

    }





    public static long getZeroCount(final long numOrg, final long decimal) throws UbiveloxException
    {
        long zeroCount = Long.MAX_VALUE;
        long zeroCountTmp;

        for ( Factor factor : getList(decimal) )
        {
            zeroCountTmp = getCount(numOrg, factor);

            if ( zeroCount > zeroCountTmp )
            {
                zeroCount = zeroCountTmp;
            }
        }

        return zeroCount;
    }





    static List<Factor> getList(final long decimal) throws UbiveloxException
    {
        List<Factor> list = new ArrayList<>();
        long n = 2;
        long number = decimal;
        long count = 0;
        if ( decimal < 2 )
        {
            throw new UbiveloxException("에러 : 값 1 또는 0 또는 음수");
        }

        if ( decimal == 2 )
        {
            list.add(new Factor(decimal, 1l));
        }
        else
        {

            // 소수 판별
            for ( int i = 2; i < Math.sqrt(decimal); i++ )
            {
                if ( Math.sqrt(decimal) % i == 0 )
                {
                    list.add(new Factor(decimal, 1));
                    return list;
                }
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

                    list.add(new Factor(n, count));
                }
                n++;
                count = 0;

            }
            while ( number != 1 );

            // 소수 판별
            // if ( list.isEmpty() )
            // {
            // list.add(new Factor(decimal, 1l));
            // }
        }

        return list;
    }





    static List<Factor> getList1(final long decimal) throws UbiveloxException
    {
        List<Factor> list = new ArrayList<>();
        long n = 2;
        long number = (long) Math.sqrt(decimal);
        long count = 0;
        if ( decimal < 2 )
        {
            throw new UbiveloxException("에러 : 값 1 또는 0 또는 음수");
        }

        if ( decimal == 2 )
        {
            list.add(new Factor(decimal, 1l));
        }
        else
        {

            // 소수 판별
            for ( int i = 2; i < Math.sqrt(decimal); i++ )
            {
                if ( Math.sqrt(decimal) % i == 0 )
                {
                    list.add(new Factor(decimal, 1));
                    return list;
                }
            }
            // 루트를 한번 씌웠기 때문에 1이라는건 이미 값임
            count += 2;
            do
            {
                if ( number % n == 0 )
                {
                    while ( number % n == 0 )
                    {

                        number /= n;
                        count += 2;
                    }

                    list.add(new Factor(n, count));
                }
                n++;
                count = 0;

            }
            while ( number != 1 );

            // 소수 판별
            // if ( list.isEmpty() )
            // {
            // list.add(new Factor(decimal, 1l));
            // }
        }

        return list;
    }





    static long getCount(final long numOrg, final Factor factor) throws UbiveloxException
    {

        long num = numOrg;
        long numResult = 0; // 최소 공약수로 나누고 나온 몫을 더한 결과

        if ( numOrg < 0 )
        {
            throw new UbiveloxException("에러 : 음수");
        }
        else if ( factor == null )
        {
            throw new UbiveloxException("에러 : Factor가 null 입니다.");
        }

        // 최소 공약수로 나누고 나온 몫을 더하는 작업
        do
        {
            num /= factor.getNumber();
            numResult += num;
        }
        while ( num > 1 );

        return numResult / factor.getExponentiation();

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
