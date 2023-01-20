package main;

public class Main {
   public static Double calc(final Double x)
    {
        final Double a = -0.5;
        final Double b = 2.0;
        Double result = 0.0;
        if(0.7 < x && x <= 1.4)
        {
            result = a * Math.pow(x, 2) * Math.log(x);
        }
        else if(x <= 0.7)
        {
            result = 1.0;
        }
        else
        if(x > 1.4)
        {
            result = Math.pow(Math.exp(1), a * x) * Math.cos(b * x);
        }
        return result;
    }
    public static Integer calcStepsByRange(Double begin, Double end, Double step)
    {
        return (int)((end - begin) / step);
    }
    public static Double[] arrayFromRange(Double begin, Double end, Double step) {
        Double[] result = new Double[calcStepsByRange(begin, end, step)];
        Double x = step;
        for (int i = 0; i < result.length; i++)
        {
            result[i] = calc(x);
            x+=step;
        }
        return result;
    }
    public static Double findMaxValue(Double []array) {
       Double maxValue = array[0];
       for(int i = 1; i < array.length; i++)
       {
           if(maxValue < array[i])
               maxValue = array[i];
       }
       return maxValue;
    }

    public static Double findMinValue(Double []array) {
        Double minValue = array[0];
        for(int i = 1; i < array.length; i++)
        {
            if(minValue > array[i])
                minValue = array[i];
        }
        return minValue;
    }
    public static Double sumArrayValues(Double []array) {
        Double sum = array[0];
        for(int i = 1; i < array.length; i++)
        {
            sum += array[i];
        }
        return sum;
    }
    public static Double arithmeticMeanOfArrayValues(Double []array) {
        return sumArrayValues(array) / array.length;
    }
    public static void main(String[] args) {
        System.out.println(arithmeticMeanOfArrayValues(arrayFromRange(0.0,3.0,0.004)));
    }
}
