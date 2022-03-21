import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the integrity of the MyArrayList
 * @author KaylaTucker
 * @version 10/3/18
 */
public class MyArrayListTest
{
    private ArrayList<String> v1 = new ArrayList<>();
    
    private MyArrayList var1;
    private MyArrayList var2;
    private MyArrayList var3;
    private MyArrayList var4;
    private MyArrayList var5;
    private MyArrayList var6;
    
    /**
     * comment
     */
    @Before
    public void setUp()
    {
        var1 = new MyArrayList<Integer>
        ( new Integer[] { 1 , 2 , 3 , 4 , 5 } );
        
        var2 = new MyArrayList<Character>
        ( new Character[] { 'a' , 'b' , 'c' } );
        
        var3 = new MyArrayList<String>
        ( new String[] { "ABC" , "DEF" , "GHI" } );
        
        var4 = new MyArrayList<>( v1 );
        
        var5 = new MyArrayList<>( 5 );
        
        var6 = new MyArrayList<>( );
    }
    
    /**
     * comment
     */
    @After
    public void cleanUp()
    {
        var1 = null;
        var2 = null;
        var3 = null;
        var4 = null;
        var5 = null;
        var6 = null;
    }
    
    /**
     * comment
     */
    @Test
    public void testAdd()
    {
        var1.add( 6 );
        assertEquals( "[1, 2, 3, 4, 5, 6]" , var1.toString() );
    }
    
    /**
     * comment
     */
    @Test
    public void testAddAt()
    {
        var1.add( 2, 6 );
        assertEquals( "[1, 2, 6, 3, 4, 5]" , var1.toString() );
    }
    
    /**
     * comment
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void testAddAtBad1()
    {
    	assertEquals( "[]" , var6.toString() );
        var1.add( 57, 6 );
    }
    
    /**
     * comment
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void testAddAtBad2()
    {
    	assertEquals( "[]" , var6.toString() );
        var1.add( -1, 6 );
    }
    
    /**
     * comment
     */
    @Test
    public void testAddAll()
    {
    	v1.add( "5" );
        var1.addAll( v1 );
        assertEquals( "[1, 2, 3, 4, 5, 5]" , var1.toString() );
    }
    
    /**
     * comment
     */
    @Test
    public void testContainsOnTrue()
    {
        assertTrue( var1.contains( 5 ) );
    }
    
    /**
     * comment
     */
    @Test
    public void testContainsOnFalse()
    {
        assertFalse( var1.contains( 0 ) );
    }
    
    /**
     * comment
     */
    @Test
    public void testEnsureCapacity()
    {
        MyArrayList<Integer> var7 = new MyArrayList<Integer>
        ( new Integer[] { 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 } );
        
        var7.add( 9 );
        
        assertEquals( "[1, 2, 3, 4, 5, 6, 7, 8, 9]" , var7.toString() );
    }
    
    /**
     * comment
     */
    @Test
    public void testGet()
    {
        assertEquals( 5 , var1.get( 4 ) );
    }
    
    /**
     * comment
     */
    @Test
    public void testindexOfThere()
    {
        assertEquals( 4 , var1.indexOf( 5 ) );
    }
    
    /**
     * comment
     */
    @Test
    public void testindexOfNotThere()
    {
        assertEquals( -1 , var1.indexOf( 6 ) );
    }
    
    /**
     * comment
     */
    @Test
    public void testLastindexOfThere()
    {
        var1.add( 4 );
        assertEquals( 5 , var1.lastIndexOf( 4 ) );
    }
    
    /**
     * comment
     */
    @Test
    public void testLastindexOfNotThere()
    {
        assertEquals( -1 , var1.lastIndexOf( 6 ) );
    }
    
    /**
     * comment
     */
    @Test
    public void testRemoveindexOfThere()
    {
        var1.remove( 0 );
        assertEquals( "[2, 3, 4, 5]" , var1.toString() );
    }
    
    /**
     * comment
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void testRemoveIndexBad1()
    {
    	assertEquals( "[]" , var6.toString() );
        var1.remove( 50 );
    }
    
    /**
     * comment
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void testRemoveIndexBad2()
    {
    	assertEquals( "[]" , var6.toString() );
        var1.remove( 6 );
    }
    
    /**
     * comment
     */
    @Test
    public void testRemoveElement1()
    {
    	v1.add( "5" );
        var4.remove( "5" );
        assertEquals( "[]" , var4.toString() );
    }
    
    /**
     * comment
     */
    @Test
    public void testRemoveElement2()
    {
        var1.remove( (Integer)2 );
        assertEquals( "[1, 3, 4, 5]" , var1.toString() );
    }
    
    /**
     * comment
     */
    @Test
    public void testRemoveElementBad()
    {
        assertFalse( var1.remove( (Object)6 ) );
    }
    
    /**
     * comment
     */
    @Test
    public void testSet()
    {
        assertEquals( 1 , var1.set( 0 , 2 ));
        assertEquals( "[2, 1, 2, 3, 4, 5]" , var1.toString() );
    }
    
    /**
     * comment
     */
    @Test
    public void testSize()
    {
        assertEquals( 5 , var1.size() );
    }
    
    /**
     * comment
     */
    @Test
    public void testSizeEmpty()
    {
        assertEquals( 0 , var6.size() );
    }
    
    /**
     * comment
     */
    @Test
    public void testIsEmptyOnTrue()
    {
        assertTrue( var6.isEmpty() );
    }
    
    /**
     * comment
     */
    @Test
    public void testIsEmptyOnFalse()
    {
        assertFalse( var1.isEmpty() );
    }
    
    /**
     * comment
     */
    @Test
    public void testClear()
    {
        var1.clear();
        assertEquals( "[]" , var1.toString() );
    }
    
    /**
     * comment
     */
    @Test
    public void removeRange1()
    {
        var1.removeRange( 0 , 3 );
        assertEquals( "[5]" ,  var1.toString() );
    }
    
    /**
     * comment
     */
    @Test
    public void removeRangeEmpty()
    {
        var1.removeRange( 1 , 1 );
        assertEquals( "[1, 2, 3, 4, 5]" ,  var1.toString() );
    }
    
    /**
     * comment
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void removeRangeBad1()
    {
    	assertEquals( "[]" , var6.toString() );
        var1.removeRange( -3 , 1 );
    }
    
    /**
     * comment
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void removeRangeBad2()
    {
    	assertEquals( "[]" , var6.toString() );
        var1.removeRange( 2 , 27 );
    }
    
    /**
     * comment
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void removeRangeBad3()
    {
    	assertEquals( "[]" , var6.toString() );
        var1.removeRange( 2 , 1 );
    }
    
    /**
     * comment
     */
    @Test
    public void testTrimToSize()
    {
        var1.trimToSize();
    }
    
    /**
     * comment
     */
    @Test
    public void testToArray()
    {
        assertArrayEquals( new Integer [] {1, 2, 3, 4, 5} , var1.toArray() );
    }
    
    /**
     * comment
     */
    @Test
    public void testToString()
    {
        assertEquals( "[1, 2, 3, 4, 5]" , var1.toString() );
    }
    
    /**
     * comment
     */
    @Test
    public void testToStringOnNull()
    {
        assertEquals( "[]" , var6.toString() );
    }
}
