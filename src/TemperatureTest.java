/** 
 * @author Aditya Mahajan <aditya.mahajan@mcgill.ca>
 * @version 2013.10.06
 * Unit Testing Temperature class
 */

import org.junit.* ;

import static org.junit.Assert.* ;

public class TemperatureTest {
	/*
	 * This helper method rounds a double to six decimal places of precision
	 */
	public double roundToSixDecimals (double number){
		  return (double) Math.round(number * 1000000) / 1000000;
	  }
  // Add multiple tests to check all functions of
  // {@Code Temperature} class.

	@Test
	public void testGetUnits () {
		/*
		 * Test the getUnits method ensuring it returns 
		 * the proper unit in all three cases
		 */
		System.out.println("Testing that getUnits() returns the proper units..");
		Temperature temp1 = new Temperature(100, Temperature.Units.CELSIUS);
		assertTrue(temp1.getUnits() == Temperature.Units.CELSIUS);
		Temperature temp2 = new Temperature(80, Temperature.Units.FAHRENHEIT);
		assertTrue(temp2.getUnits() == Temperature.Units.FAHRENHEIT);
		Temperature temp3 = new Temperature(273, Temperature.Units.KELVIN);
		assertTrue(temp3.getUnits() == Temperature.Units.KELVIN);
	}

  @Test
  public void testGetValue (){
	  /*
	   * Test the getValue method to ensure it returns the correct value
	   * of the temperature with a precision of 1e^-6. 
	   * There are three cases that must be tested
	   */

	  System.out.println("Testing that GetValue() returns the proper values..");
	  Temperature temp1 = new Temperature(37, Temperature.Units.CELSIUS);
	  assertTrue(temp1.getValue() == 37);
	  Temperature temp2 = new Temperature(91.000000, Temperature.Units.FAHRENHEIT);
	  assertTrue(roundToSixDecimals(temp2.getValue()) == 91.000000);
	  Temperature temp3 = new Temperature(317, Temperature.Units.KELVIN);
	  assertTrue(roundToSixDecimals(temp3.getValue()) == 317.000000);  
  }
  /*
   * Testing changeUnits() in three separate tests, one for each Unit
   * Test will check for border cases and meaningful values.
   */
  @Test
  public void testChangeUnitstoFahrenheit () {
	  /*
	   * Testing changeUnits() method to change from Celsius and Kelvin to Fahrenheit
	   * Tests 0 C (boder case) and -5 C (changing from +/1) to Fahrenheit
	   *   		 and 273.15 K to Fahrenheit (border case)
	   */
	  System.out.println("Testing changeUnits() to convert to Fahrenheit..");
	  Temperature temp1 = new Temperature(0, Temperature.Units.CELSIUS);
	  temp1.changeUnits(Temperature.Units.FAHRENHEIT);
	  assertTrue(roundToSixDecimals(temp1.getValue()) == 32.000000);
	  Temperature temp2 = new Temperature(-5, Temperature.Units.CELSIUS);
	  temp2.changeUnits(Temperature.Units.FAHRENHEIT);
	  assertTrue(roundToSixDecimals(temp2.getValue()) == 23.000000);
	  Temperature temp3 = new Temperature(273.15, Temperature.Units.KELVIN);
	  temp3.changeUnits(Temperature.Units.FAHRENHEIT);
	  assertTrue(roundToSixDecimals(temp3.getValue()) == 32.000000);
  }
  @Test 
  public void testChangeUnitstoCelcius() {
	/*
	 * Testing 32 F (border case) and 95 F (average case) to Celsius
	 *  	& 273.15 K (border case) to Celsius
	 */
	  System.out.println("Testing changeUnits() to convert to Celsius..");
	  Temperature temp1 = new Temperature(32, Temperature.Units.FAHRENHEIT);
	  temp1.changeUnits(Temperature.Units.CELSIUS);
	  assertTrue(roundToSixDecimals(temp1.getValue()) == 0.000000);
	  Temperature temp2 = new Temperature(95, Temperature.Units.FAHRENHEIT);
	  temp2.changeUnits(Temperature.Units.CELSIUS);
	  assertTrue(roundToSixDecimals(temp2.getValue()) == 35.000000);
	  Temperature temp3 = new Temperature(273.15, Temperature.Units.KELVIN);
	  temp3.changeUnits(Temperature.Units.CELSIUS);
	  assertTrue(roundToSixDecimals(temp3.getValue()) == 0.000000);

  }
  @Test
  public void testChangetoKelvin(){
	  /*
	   * Testing 0 C, 12 C (average case) and -5C (negative to positive) to Kelvin
	   * 	& 32 F and 70 F to Kelvin
	   */
	  System.out.println("Testing changeUnits() to convert to Kelvin..");
	  Temperature temp1 = new Temperature(0.00, Temperature.Units.CELSIUS);
	  temp1.changeUnits(Temperature.Units.KELVIN);
	  assertTrue(roundToSixDecimals(temp1.getValue()) == 273.150000);
	  Temperature temp2 = new Temperature(12.00, Temperature.Units.CELSIUS);
	  temp2.changeUnits(Temperature.Units.KELVIN);
	  assertTrue(roundToSixDecimals(temp2.getValue()) == 285.150000);
	  Temperature temp3 = new Temperature(-5.00, Temperature.Units.CELSIUS);
	  temp3.changeUnits(Temperature.Units.KELVIN);
	  assertTrue(roundToSixDecimals(temp3.getValue()) == 268.150000);
	  Temperature temp4 = new Temperature(32, Temperature.Units.FAHRENHEIT);
	  temp4.changeUnits(Temperature.Units.KELVIN);
	  assertTrue(roundToSixDecimals(temp3.getValue()) == 0.000000);
	  Temperature temp5 = new Temperature(70, Temperature.Units.FAHRENHEIT);
	  temp5.changeUnits(Temperature.Units.KELVIN);
	  assertTrue(roundToSixDecimals(temp3.getValue()) == 294.261000);
  }
  
}

