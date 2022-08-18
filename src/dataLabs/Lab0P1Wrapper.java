package dataLabs;

public class Lab0P1Wrapper {

	public static interface BaseVector {
		public double getXComponent();
		public double getYComponent();
		public double getMagnitude();
		public double getAngle();
		public BaseVector add(BaseVector V);
		public BaseVector subtract(BaseVector V);
		public double dotProduct(BaseVector V);
		public BaseVector crossProduct(BaseVector V);
	}

	public static class VectorComponent implements BaseVector {

		private double X;
		private double Y;

		public VectorComponent(double X, double Y) {
			/*TODO ADD YOUR CODE HERE*/
			this.X = X;
			this.Y = Y;
		}


		@Override
		public double getXComponent() {
			/*TODO ADD YOUR CODE HERE*/
			return X; //Dummy Return
		}

		@Override
		public double getYComponent() {
			/*TODO ADD YOUR CODE HERE*/
			return Y; //Dummy Return
		}

		public void setX(double x) {
			/*TODO ADD YOUR CODE HERE*/
			this.X = x;
		}

		public void setY(double y) {
			/*TODO ADD YOUR CODE HERE*/
			this.Y = y;
		}

		@Override
		public BaseVector add(BaseVector V) {
			/*TODO ADD YOUR CODE HERE*/ 
			
			return V;
			
		}

		@Override
		public BaseVector subtract(BaseVector V) {
			/*TODO ADD YOUR CODE HERE*/
			this.X = V.getXComponent() - X;
			this.Y = V.getYComponent() - Y; 
			return null; //Dummy Return
		}

		@Override
		public double dotProduct(BaseVector V) {
			/*TODO ADD YOUR CODE HERE*/
			return 0.0; //Dummy Return
		}

		@Override
		public BaseVector crossProduct(BaseVector V) {
			/**
			 * TODO ADD YOUR CODE HERE

			 * Can you do a cross product of 2D vectors?
			 * If not, what should we do?
			 * 
			 * Hint: Look up what UnsopportedOperationException does!
			 */
			return null; //Dummy Return
		}


		@Override
		public double getMagnitude() {
			/*TODO ADD YOUR CODE HERE*/
			return 0.0; //Dummy Return
		}

		@Override
		public double getAngle() {
			/*TODO ADD YOUR CODE HERE*/
			return 0.0; //Dummy Return
		}	
	}
}

