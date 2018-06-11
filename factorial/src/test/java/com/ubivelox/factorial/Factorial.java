package com.ubivelox.factorial;

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
        for ( Factor factor : getFractionalDecomposition(decimal) )
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

        return list;
    }





    static List<Factor> getFractionalDecomposition(final long decimal) throws UbiveloxException
    {
        List<Factor> list = new ArrayList<>();
        long n = 2;
        long number = decimal;
        double sqrtn = Math.sqrt(number);
        long count = 0;

        if ( decimal < 2 )
        {
            throw new UbiveloxException("에러 : 값 1 또는 0 또는 음수");
        }
        else if ( decimal == 2 )
        {
            list.add(new Factor(decimal, 1l));
        }
        else
        {
            while ( number % n == 0 )
            {
                number /= n;
                count++;
            }

            if ( count != 0 )
            {
                list.add(new Factor(n, count));
            }

            n++;

            do
            {
                count = 0;
                if ( number % n == 0 )
                {
                    while ( number % n == 0 )
                    {
                        number /= n;
                        count++;
                    }

                    list.add(new Factor(n, count));
                }

                n += 2;
            }
            while ( number != 1 && n <= sqrtn );

            // 소수 판별
            // if ( list.isEmpty() )
            // {
            // list.add(new Factor(decimal, 1));
            // }
            // else
            if ( number != 1 )
            { // 진수의 마지막 약수가 number에 남아 있음
                list.add(new Factor(number, 1));

            }
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
}
