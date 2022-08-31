package lab1;

public class Lab01P1Wrapper {
	
	private static class Arithmetic{
		/*TODO ADD THE FOLLOWING:
		 * PRIVATE FIELDS, 
		 * CONSTRUCTOR, 
		 * GETTERS, 
		 * SETTERS, 
		 * MEMBER METHODS
		 */
private int a, b;
		
		public Arithmetic(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}

		public int getB() {
			return b;
		}

		public void setB(int b) {
			this.b = b;
		}
		
		public int add() {
			return a + b;
		}
		public int subtract() {
			return a - b;
		}
		public int multiply() {
			return a * b;
		}
		public int divide() {
			if(b != 0) {
				return a / b;
			}
			else return 0;
		}
	}
	
	public static class Calculator extends Arithmetic /*TODO What is missing here?*/{

		/*TODO ADD CONSTRUCTOR HERE*/
		public Calculator(int a, int b) {
			super(a, b);
		}
	}
}

