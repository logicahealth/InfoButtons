package org.openinfobutton.app.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import junit.framework.TestCase;

/**
 *
 * @author rick
 */
public class ValueSetTest extends TestCase {
    
    /**
     * Test of getValueSetId method, of class ValueSet.
     */
    public void testSetGetValueSetId() {
        System.out.println("getValueSetId");
        ValueSet instance = new ValueSet();
        instance.setValueSetId(BigDecimal.ONE);
        BigDecimal expResult = BigDecimal.ONE;
        BigDecimal result = instance.getValueSetId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValueSetTypeCode method, of class ValueSet.
     */
    public void testSetGetValueSetTypeCode() {
        System.out.println("getValueSetTypeCode");
        ValueSet instance = new ValueSet();
        instance.setValueSetTypeCode("myTypeCode");
        String expResult = "myTypeCode";
        String result = instance.getValueSetTypeCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValueSetOid method, of class ValueSet.
     */
    public void testSetGetValueSetOid() {
        System.out.println("getValueSetOid");
        ValueSet instance = new ValueSet();
        instance.setValueSetOid("oid.oid.oid");
        String expResult = "oid.oid.oid";
        String result = instance.getValueSetOid();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValueSetDisplayName method, of class ValueSet.
     */
    public void testSetGetValueSetDisplayName() {
        System.out.println("getValueSetDisplayName");
        ValueSet instance = new ValueSet();
        instance.setValueSetDisplayName("myDisplay");
        String expResult = "myDisplay";
        String result = instance.getValueSetDisplayName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValueSetUri method, of class ValueSet.
     */
    public void testSetGetValueSetUri() {
        System.out.println("getValueSetUri");
        ValueSet instance = new ValueSet();
        instance.setValueSetUri("http://uri.com/blablabla");
        String expResult = "http://uri.com/blablabla";
        String result = instance.getValueSetUri();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValueSetCodes method, of class ValueSet.
     */
    public void testSetGetValueSetCodes() {
        System.out.println("getValueSetCodes");
        Collection<ValueSetCode> testSet = new ArrayList<ValueSetCode>();
        ValueSetCode valueSetCode = new ValueSetCode();
        testSet.add(valueSetCode);
        ValueSet instance = new ValueSet();
        instance.setValueSetCodes(testSet);
        Collection<ValueSetCode> result = instance.getValueSetCodes();
        assertEquals(testSet, result);
    }

    /**
     * Test of hashCode method, of class ValueSet.
     */
    public void testHashCode1() {
        System.out.println("hashCode");
        ValueSet instance = new ValueSet();
        instance.setValueSetId(BigDecimal.ONE);
        ValueSet instance2 = new ValueSet();
        instance2.setValueSetId(BigDecimal.ONE);
        assertTrue(instance.hashCode() == instance2.hashCode());
    }

    public void testHashCode2() {
        System.out.println("hashCode");
        ValueSet instance = new ValueSet();
        instance.setValueSetId(BigDecimal.ONE);
        ValueSet instance2 = new ValueSet();
        instance2.setValueSetId(BigDecimal.TEN);
        assertTrue(instance.hashCode() != instance2.hashCode());
    }

    public void testHashCode3() {
        System.out.println("hashCode");
        ValueSet instance = new ValueSet();
        instance.setValueSetId(BigDecimal.ONE);
        assertTrue(instance.hashCode() == (BigDecimal.ONE).hashCode());
    }

    public void testHashCode4() {
        System.out.println("hashCode");
        ValueSet instance = new ValueSet();
        instance.setValueSetId(BigDecimal.ONE);
        assertTrue(instance.hashCode() == (BigDecimal.ONE).hashCode());
    }

    /**
     * Test of equals method, of class ValueSet.
     */
    public void testEquals1() {
        System.out.println("equals");
        Object object = null;
        ValueSet instance = new ValueSet();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    public void testEquals2() {
        System.out.println("equals");
        ValueSet instance = new ValueSet();
        instance.setValueSetId(BigDecimal.ONE);
        ValueSet instance2 = new ValueSet();
        instance2.setValueSetId(BigDecimal.ONE);
        boolean expResult = true;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

    public void testEquals3() {
        System.out.println("equals");
        ValueSet instance = new ValueSet();
        ValueSet instance2 = new ValueSet();
        boolean expResult = true;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

    public void testEquals4() {
        System.out.println("equals");
        ValueSet instance = new ValueSet();
        instance.setValueSetId(BigDecimal.ONE);
        ValueSet instance2 = new ValueSet();
        instance2.setValueSetId(BigDecimal.TEN);
        boolean expResult = false;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

    public void testEquals5() {
        System.out.println("equals");
        ValueSet instance = new ValueSet();
        ValueSet instance2 = null;
        boolean expResult = false;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

    public void testEquals6() {
        System.out.println("equals");
        ValueSet instance = new ValueSet();
        ValueSet instance2 = new ValueSet();
        instance2.setValueSetId(BigDecimal.ONE);
        boolean expResult = false;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ValueSet.
     */
    public void testToString() {
        System.out.println("toString");
        ValueSet instance = new ValueSet();
        instance.setValueSetId(BigDecimal.ONE);
        String expResult = "org.openinfobutton.responder.model.ValueSet[ valueSetId=" + BigDecimal.ONE + "\t" + null + " ]";

        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
