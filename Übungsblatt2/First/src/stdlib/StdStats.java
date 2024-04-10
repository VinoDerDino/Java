package stdlib;

import SortingAlgorithms.Bubblesort;

public class StdStats {

    public static void main(String[] args) {
        double[] a = new double[5];
        for(int i = 0; i < 5; i++)
        {
            a[i] = i;
        }

        //plotPoints(a);
        plotLines(a);
    }

    public static double max(double[] a)
    {
        double maximum = a[0];
        for(int i = 1; i < a.length; i++)
        {
            if(a[i] > maximum)
            {
                maximum = a[i];
            }
        }
        return maximum;
    }

    public static double min(double[] a)
    {
        double minimum = a[0];
        for(int i = 1; i < a.length; i++)
        {
            if(a[i] < minimum)
            {
                minimum = a[i];
            }
        }
        return minimum;
    }
    
    public static double average(double[] a)
    {
        double average = 0;
        for(int i = 1; i < a.length; i++)
        {
            average += a[i];
        }
        return (average / a.length);
    }

    public static double variance(double[] a)
    {
        double avr = average(a);
        double outcome = 0;

        for(int i = 0; i < a.length; i++)
        {
            outcome += (a[i] - avr) * (a[i] - avr);
        }
        return outcome / (a.length - 1);
    }

    public static double stddev(double[] a)
    {
        double v = variance(a);
        return Math.sqrt(v);
    }

    public static double median(double[] a)
    {
        a = Bubblesort.bubble(a);                   //call the bubblesort algorithm
        if(a.length % 2 == 0)
        {
            return (a[(a.length / 2) - 1] + a[a.length / 2]) / 2;
        }
        else
        {
            return a[(a.length + 1) / 2];
        }
    }

    public static void plotScales(double[] a)
    {
        StdDraw.setXscale(-0.5, a.length -0.5);
        StdDraw.setYscale(min(a) - 0.5, max(a) + 0.5);
        StdDraw.setPenRadius(0.005);                             

        StdDraw.line(-0.4, min(a) - 0.4, a.length - 0.6, min(a) - 0.4);
        StdDraw.line(-0.4, min(a) - 0.4, -0.4, max(a) + 0.4);

        for(int i = 0; i < a.length; i++)
        {
            StdDraw.text(-0.3, i, Integer.toString(i));
            StdDraw.text(i, min(a) - 0.3, Integer.toString(i));
        }
    }

    public static void plotPoints(double[] a)
    {
        plotScales(a);
        StdDraw.setPenRadius(0.01);                             //for points

        for(int i = 0; i < a.length; i++)
        {
            StdDraw.point(i, a[i]);
        }
        
    }

    public static void plotLines(double[] a)
    {
        plotScales(a);
        StdDraw.setPenRadius(0.005);

        for(int i = 0; i < a.length - 1; i++)
        {
            StdDraw.line(i, a[i], i + 1, a[i + 1]);
        }
    }

    public static void plotBars(double[] a)
    {
        plotScales(a);
        
    }
}
