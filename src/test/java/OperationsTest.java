import com.sun.jdi.DoubleValue;
import org.example.Operations;
import org.example.Polynomial;
import org.junit.Test;

import java.util.Collections;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class OperationsTest {

    @Test
    public void addPolynomialsTest1(){
        TreeMap<Integer,Integer> polinom1=new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer,Integer> polinom2=new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer,Integer> result=new TreeMap<>(Collections.reverseOrder());


        polinom1.merge(5,4,Integer::sum);
        polinom1.merge(4,-3,Integer::sum);
        polinom1.merge(2,1,Integer::sum);
        polinom1.merge(1,-8,Integer::sum);
        polinom1.merge(0,1,Integer::sum);

        polinom2.merge(4,3,Integer::sum);
        polinom2.merge(3,-1,Integer::sum);
        polinom2.merge(2,1,Integer::sum);
        polinom2.merge(1,2,Integer::sum);
        polinom2.merge(0,-1,Integer::sum);

        result.merge(5,4,Integer::sum);
        result.merge(3,-1,Integer::sum);
        result.merge(2,2,Integer::sum);
        result.merge(1,-6,Integer::sum);

        assertEquals(Operations.addPolynomials(polinom1,polinom2),Operations.BuildString(result));

    }

    @Test
    public void addPolynomialsTest2(){
        TreeMap<Integer,Integer> polinom1=new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer,Integer> polinom2=new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer,Integer> result=new TreeMap<>(Collections.reverseOrder());


        polinom1.merge(5,4,Integer::sum);
        polinom1.merge(4,-3,Integer::sum);
        polinom1.merge(2,1,Integer::sum);
        polinom1.merge(1,-8,Integer::sum);
        polinom1.merge(0,1,Integer::sum);

        polinom2.merge(4,3,Integer::sum);
        polinom2.merge(3,-1,Integer::sum);
        polinom2.merge(2,1,Integer::sum);
        polinom2.merge(1,2,Integer::sum);
        polinom2.merge(0,-1,Integer::sum);

        result.merge(5,-4,Integer::sum);
        result.merge(3,-1,Integer::sum);
        result.merge(2,2,Integer::sum);
        result.merge(1,-6,Integer::sum);

        assertEquals(Operations.addPolynomials(polinom1,polinom2),Operations.BuildString(result));

    }

    @Test
    public void subPolynomialTest1(){
        TreeMap<Integer,Integer> polinom1=new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer,Integer> polinom2=new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer,Integer> result=new TreeMap<>(Collections.reverseOrder());


        polinom1.merge(5,4,Integer::sum);
        polinom1.merge(4,-3,Integer::sum);
        polinom1.merge(2,1,Integer::sum);
        polinom1.merge(1,-8,Integer::sum);
        polinom1.merge(0,1,Integer::sum);

        polinom2.merge(4,3,Integer::sum);
        polinom2.merge(3,-1,Integer::sum);
        polinom2.merge(2,1,Integer::sum);
        polinom2.merge(1,2,Integer::sum);
        polinom2.merge(0,-1,Integer::sum);

        result.merge(5,4,Integer::sum);
        result.merge(4,-6,Integer::sum);
        result.merge(3,1,Integer::sum);
        result.merge(1,-10,Integer::sum);
        result.merge(0,2,Integer::sum);


        assertEquals(Operations.subPolynomials(polinom1,polinom2),Operations.BuildString(result));
    }

    @Test
    public void subPolynomialTest2(){
        TreeMap<Integer,Integer> polinom1=new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer,Integer> polinom2=new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer,Integer> result=new TreeMap<>(Collections.reverseOrder());


        polinom1.merge(5,4,Integer::sum);
        polinom1.merge(4,-3,Integer::sum);
        polinom1.merge(2,1,Integer::sum);
        polinom1.merge(1,-8,Integer::sum);
        polinom1.merge(0,1,Integer::sum);

        polinom2.merge(4,3,Integer::sum);
        polinom2.merge(3,-1,Integer::sum);
        polinom2.merge(2,1,Integer::sum);
        polinom2.merge(1,2,Integer::sum);
        polinom2.merge(0,-1,Integer::sum);

        result.merge(5,4,Integer::sum);
        result.merge(4,-6,Integer::sum);
        result.merge(3,1,Integer::sum);
        result.merge(1,10,Integer::sum);
        result.merge(0,2,Integer::sum);


        assertEquals(Operations.subPolynomials(polinom1,polinom2),Operations.BuildString(result));
    }

    @Test
    public void divPolynomialTest1(){
        TreeMap<Integer,Integer> polinom1=new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer,Integer> polinom2=new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer,Integer> result1=new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer,Integer> result2=new TreeMap<>(Collections.reverseOrder());


        polinom1.merge(3,1,Integer::sum);
        polinom1.merge(2,-2,Integer::sum);
        polinom1.merge(1,6,Integer::sum);
        polinom1.merge(0,-5,Integer::sum);

        polinom2.merge(2,1,Integer::sum);
        polinom2.merge(0,-1,Integer::sum);

        result1.merge(1,1,Integer::sum);
        result1.merge(0,-2,Integer::sum);

        result2.merge(1,7,Integer::sum);
        result2.merge(0,-7,Integer::sum);


        assertEquals(Operations.divPolynomials(polinom1,polinom2),"Quotient: " + Operations.BuildString(result1) + ", Remainder: " + Operations.BuildString(result2));
    }

    @Test
    public void divPolynomialTest2(){
        TreeMap<Integer,Integer> polinom1=new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer,Integer> polinom2=new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer,Integer> result1=new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer,Integer> result2=new TreeMap<>(Collections.reverseOrder());


        polinom1.merge(3,1,Integer::sum);
        polinom1.merge(2,-2,Integer::sum);
        polinom1.merge(1,6,Integer::sum);
        polinom1.merge(0,-5,Integer::sum);

        polinom2.merge(2,1,Integer::sum);
        polinom2.merge(0,-1,Integer::sum);

        result1.merge(1,1,Integer::sum);
        result1.merge(0,-2,Integer::sum);

        result2.merge(1,7,Integer::sum);
        result2.merge(0,-2,Integer::sum);


        assertEquals(Operations.divPolynomials(polinom1,polinom2),"Quotient: " + Operations.BuildString(result1) + ", Remainder: " + Operations.BuildString(result2));
    }

    @Test
    public void mulPolynomialsTest1(){
        TreeMap<Integer,Integer> polinom1=new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer,Integer> polinom2=new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer,Integer> result=new TreeMap<>(Collections.reverseOrder());


        polinom1.merge(2,3,Integer::sum);
        polinom1.merge(1,-1,Integer::sum);
        polinom1.merge(0,1,Integer::sum);

        polinom2.merge(1,1,Integer::sum);
        polinom2.merge(0,-2,Integer::sum);

        result.merge(3,3,Integer::sum);
        result.merge(2,-7,Integer::sum);
        result.merge(1,3,Integer::sum);
        result.merge(0,-2,Integer::sum);


        assertEquals(Operations.mulPolynomials(polinom1,polinom2),Operations.BuildString(result));


    }

    @Test
    public void mulPolynomialsTest2(){
        TreeMap<Integer,Integer> polinom1=new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer,Integer> polinom2=new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer,Integer> result=new TreeMap<>(Collections.reverseOrder());


        polinom1.merge(2,3,Integer::sum);
        polinom1.merge(1,-1,Integer::sum);
        polinom1.merge(0,1,Integer::sum);

        polinom2.merge(1,1,Integer::sum);
        polinom2.merge(0,-2,Integer::sum);

        result.merge(3,4,Integer::sum);
        result.merge(2,-7,Integer::sum);
        result.merge(1,3,Integer::sum);
        result.merge(0,-2,Integer::sum);


        assertEquals(Operations.mulPolynomials(polinom1,polinom2),Operations.BuildString(result));


    }

    @Test
    public void derPolynomialsTest1(){
        TreeMap<Integer,Integer> polinom1=new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer,Integer> result=new TreeMap<>(Collections.reverseOrder());


        polinom1.merge(3,1,Integer::sum);
        polinom1.merge(2,-2,Integer::sum);
        polinom1.merge(1,6,Integer::sum);
        polinom1.merge(0,-5,Integer::sum);


        result.merge(2,3,Integer::sum);
        result.merge(1,-4,Integer::sum);
        result.merge(0,6,Integer::sum);


        assertEquals(Operations.derPolynomials(polinom1),Operations.BuildString(result));


    }

    @Test
    public void derPolynomialsTest2(){
        TreeMap<Integer,Integer> polinom1=new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer,Integer> result=new TreeMap<>(Collections.reverseOrder());


        polinom1.merge(3,1,Integer::sum);
        polinom1.merge(2,-2,Integer::sum);
        polinom1.merge(1,6,Integer::sum);
        polinom1.merge(0,-5,Integer::sum);


        result.merge(2,3,Integer::sum);
        result.merge(1,4,Integer::sum);
        result.merge(0,6,Integer::sum);


        assertEquals(Operations.derPolynomials(polinom1),Operations.BuildString(result));


    }

    @Test
    public void intPolynomialsTest1(){
        TreeMap<Integer,Integer> polinom1=new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer,Double> result=new TreeMap<>(Collections.reverseOrder());


        polinom1.merge(3,4,Integer::sum);
        polinom1.merge(2,-3,Integer::sum);
        polinom1.merge(1,6,Integer::sum);
        polinom1.merge(0,-5,Integer::sum);


        result.merge(4,1.0,Double::sum);
        result.merge(3,-1.0,Double::sum);
        result.merge(2,3.0,Double::sum);
        result.merge(1,-5.0, Double::sum);


        assertEquals(Operations.intPolynomials(polinom1),Operations.BuildString1(result));


    }

    @Test
    public void intPolynomialsTest2(){
        TreeMap<Integer,Integer> polinom1=new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer,Double> result=new TreeMap<>(Collections.reverseOrder());


        polinom1.merge(3,4,Integer::sum);
        polinom1.merge(2,-3,Integer::sum);
        polinom1.merge(1,6,Integer::sum);
        polinom1.merge(0,-5,Integer::sum);


        result.merge(4,1.0,Double::sum);
        result.merge(3,-1.0,Double::sum);
        result.merge(2,4.0,Double::sum);
        result.merge(1,-5.0, Double::sum);


        assertEquals(Operations.intPolynomials(polinom1),Operations.BuildString1(result));


    }
}
