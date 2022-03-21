import java.util.ArrayList;
import java.util.Collection;

/**
 * My recreation of the ArrayList class
 * @author Kayla Tucker
 * @version (10/4/2018)
 * @param E element
 */
public class MyArrayList<E>
{
    private int size;
    private Object [] vals;
    
    /**
     * Default constructor.
     */
    public MyArrayList()
    {
        this.vals = new Object [ 8 ];
        size = 0;
    }
    
    /**
     * To make my life less painful.
     * @param values array of Object(s)
     */
    public MyArrayList( Object [] values )
    {
        this.vals = new Object [ 8 ];
        
        ensureCapacity( values.length );
        
        size = values.length;
        
        for ( int i = 0 ; i < size ; i++ )
        {
            vals[ i ] = values[ i ];
        }
    }
    
    /**
     * Transfers a List into a MyArrayList.
     * @param values ArrayList of E
     */
    public MyArrayList( Collection<E> values )
    {
        this.vals = new Object [ 8 ];
        
        size = values.size();
        
        ensureCapacity( values.size() );
        
        for ( E o : values )
        {
            this.add( o );
        }
    }
    
    /**
     * Initializes the array with a cap.
     * @param int cap becomes the length of the
     * background array
     */
    public MyArrayList( int cap )
    {
        this.vals = new Object [ cap ];
        size = 0;
    }
    
    /**
     * Adds an element to the end of an array.
     * @param E e based on element given to class
     * @returns true or false depending on
     * if element E was added or not.
     */
    public boolean add( E e )
    {
        ensureCapacity( size );
        
        size++;
        vals[ size - 1 ] = e;
        
        return true;
    }
    
    /**
     * Adds an element at the index specified.
     * Shifts all elements around as necessary.
     * @param int index given
     * @param E element given.
     */
    public void add( int index , E e )
    {
        checkIndex( index );
        
        ensureCapacity( size );
        
        size++;
        for ( int i = size ; i >= index + 1 ; i-- )
        {
            vals[ i ] = vals[ i - 1 ];
        }
        vals[ index ] = ( Object )e;
    }
    
    /**
     * Adds an array of elements to the current ArrayList.
     * @param Collection of type E
     */
    public void addAll( Collection<E> e )
    {
        for ( E o : e )
        {
            this.add( o );
        }
    }
    
    /**
     * Sets the size to zero and reinitializes the
     * background array.
     */
    public void clear()
    {
        this.vals = new Object [ 8 ];
        
        size = 0;
    }
    
    /**
     * Searches the array for the given element.
     * @param E element based on class type
     * @returns true or false depending on if element E
     * was found or not.
     */
    public boolean contains( E e )
    {
        for ( int i = 0 ; i < size ; i++ )
        {
            if ( vals[ i ].equals( (Object)e ) )
            {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Ensures that the background array can handle
     * the space requirements for the next option.
     * If not, the background array's length is increased
     * accordingly.
     * @param int minCap is the lowest possible size
     */
    public void ensureCapacity( int minCap )
    {
        if ( vals.length == minCap )
        {
            Object [] newVals;
            
            if ( vals.length > ( Integer.MAX_VALUE / 2 ) )
            {
                newVals = new Object[ Integer.MAX_VALUE ];
            }
            else
            {
                newVals = new Object[ vals.length * 2 ];
            }
            
            for ( int i = 0 ; i < size ; i++ )
            {
                newVals[ i ] = vals[ i ];
            }
            
            vals = newVals;
        }
    }
    
    /**
     * @param int i for the index
     * @returns the Object at the given index.
     */
    public Object get( int i )
    {
        return vals[ i ];
    }
    
    /**
     * Searches the array for a given element.
     * @param E element based on class
     * @returns -1 if int index isn't found
     */
    public int indexOf( E e )
    {
        for ( int i = 0 ; i < size ; i++ )
        {
            if ( vals[ i ].equals( e ) )
            {
                return i;
            }
        }
        
        return -1;
    }
    
    /**
     * @returns true only if MyArrayList contains no elements.
     */
    public boolean isEmpty()
    {
        return size <= 0;
    }
    
    /**
     * @param E element based on class
     * @returns The last occurrence of an
     * element in MyArrayList. If never found,
     * returns -1.
     */
    public int lastIndexOf( E e )
    {
        for ( int i = this.size() - 1 ; i >= 0 ; i-- )
        {
            if ( vals[ i ].equals( (Object)e ) )
            {
                return i;
            }
        }
        
        return -1;
    }
    
    /**
     * Removes the element at the given index.
     * @param int index to be found
     * @returns The element at the index
     * before it was removed.
     */
    public Object remove( int index )
    {
        checkIndex( index );
        
        Object oldVal = vals[ index ];
        
        for ( int i = index ; i < size - 1 ; i++ )
        {
            vals[ i ] = vals[ i + 1 ];
        }
        
        vals[ size - 1 ] = null;
        size--;
        
        return oldVal;
    }
    
    /**
     * Removes the first occurrence of the
     * given element from MyArrayList.
     * @param E element based on class
     * @returns true if it was found and removed,
     * false otherwise.
     */
    public boolean remove( E e )
    {
        if ( indexOf( e ) != -1 )
        {
            if ( size > 1 )
            {
                for ( int i = indexOf( e ) ; i < size ; i++ )
                {
                    if ( i == indexOf( e ) )
                    {
                        vals[ i ] = null;
                    }
                    
                    vals[ i ] = vals[ i + 1 ];
                }
            }
            
            size--;
            return true;
        }
        
        return false;
    }
    
    /**
     * Replaces the element at the given index
     * with the given element.
     * @param int index and E e are the index the element
     * given should be in
     * @returns the element previously in that slot.
     */
    public Object set( int index , E e )
    {
        checkIndex( index );
        
        ensureCapacity( size );
        size++;
        
        Object oldVal = vals[ index ];
        for ( int i = size - 1 ; i >= index ; i-- )
        {
            if ( i == index )
            {
                vals[ index ] = e;
            }
            else
            {
                vals[ i ] = vals[ i - 1 ];
            }
        }
        
        return oldVal;
    }
    
    /**
     * @returns The current size of MyArrayList
     */
    public int size()
    {
        return size;
    }
    
    /**
     * Sets the background array's length to
     * that of the current size.
     */
    public void trimToSize()
    {
        this.vals = new Object [ size ];
        
        ArrayList<E> newVals = new ArrayList<>( size );
        
        this.addAll( newVals );
    }
    
    /**
     * Removes a set of elements in 
     * "from"(inclusive) 
     * to "to"(exclusive)
     * @param int to is the end index
     * @param int from is the starting index
     */
    public void removeRange( int from , int to)
    {
        if ( ( from < 0 ) || ( to > size ) || ( to < from ) )
        {
            throw new IndexOutOfBoundsException();
        }
        
        if ( from != to )
        {
            for ( int i = to ; i >= from ; i-- )
            {
                this.remove( i );
            }
        }
    }
    
    /**
     * 
     * @returns an Object array of elements currently
     * in MyArrayList.
     */
	public Object [] toArray()
    {
        ArrayList<E> newVals = new ArrayList<>();
        
        for ( int i = 0 ; i < size ; i++ )
        {
            newVals.add( (E)vals[ i ] );
        }
        
        return newVals.toArray();
    }
    
    /**
     * @returns a String that lists the elements in
     * the current ArrayList.
     */
    public String toString()
    {
        if ( size == 0 )
        {
            return "[]";
        }
        
        StringBuilder str = new StringBuilder( "[" );
        
        for ( int i = 0 ; i < size - 1 ; i++ )
        {
            str.append( vals[ i ] + ", " );
        }
        
        str.append( vals[ size - 1 ] + "]" );
        
        return str.toString();
    }
    
    /**
     * Checks the index's bounds.
     * @param int index is to be checked for
     * boundaries in MyArrayList
     */
    public void checkIndex( int index )
    {
        if ( index < 0 || index >= this.size() )
        {
            throw new IndexOutOfBoundsException();
        }
    }
}
