

interface Chain {
	// Defines the next Object to receive the data

	// if this Object can't process it

	public void setNextChain(Chain nextChain);

	// Either solves the problem or passes the data

	// to the next Object in the chain

	public void calculate(Numbers request);
}

class Numbers {

	private int number1;

	private int number2;

	private String calculationWanted;

	public Numbers(int newNumber1, int newNumber2, String calcWanted) {

		number1 = newNumber1;

		number2 = newNumber2;

		calculationWanted = calcWanted;

	}

	public int getNumber1() {
		return number1;
	}

	public int getNumber2() {
		return number2;
	}

	public String getCalcWanted() {
		return calculationWanted;
	}

}

class AddNumbers implements Chain {

	private Chain nextInChain;

	// Defines the next Object to receive the
	// data if this one can't use it

	public void setNextChain(Chain nextChain) {

		nextInChain = nextChain;

	}

	// Tries to calculate the data, or passes it
	// to the Object defined in method setNextChain()

	public void calculate(Numbers request) {

		if (request.getCalcWanted() == "add") {

			System.out.print(request.getNumber1() + " + " + request.getNumber2() + " = "
					+ (request.getNumber1() + request.getNumber2()));

		} else {

			nextInChain.calculate(request);

		}

	}
}

class SubtractNumbers implements Chain {

	private Chain nextInChain;

	@Override
	public void setNextChain(Chain nextChain) {

		nextInChain = nextChain;

	}

	@Override
	public void calculate(Numbers request) {

		if (request.getCalcWanted() == "sub") {

			System.out.print(request.getNumber1() + " - " + request.getNumber2() + " = "
					+ (request.getNumber1() - request.getNumber2()));

		} else {

			nextInChain.calculate(request);

		}

	}

}

class MultNumbers implements Chain {

	private Chain nextInChain;

	@Override
	public void setNextChain(Chain nextChain) {

		nextInChain = nextChain;

	}

	@Override
	public void calculate(Numbers request) {

		if (request.getCalcWanted() == "mult") {

			System.out.print(request.getNumber1() + " * " + request.getNumber2() + " = "
					+ (request.getNumber1() * request.getNumber2()));

		} else {

			nextInChain.calculate(request);

		}

	}

}

class DivideNumbers implements Chain {

	private Chain nextInChain;

	@Override
	public void setNextChain(Chain nextChain) {

		nextInChain = nextChain;

	}

	@Override
	public void calculate(Numbers request) {

		if (request.getCalcWanted() == "div") {

			System.out.print(request.getNumber1() + " / " + request.getNumber2() + " = "
					+ (request.getNumber1() / request.getNumber2()));

		} else {

			System.out.print("Only works for add, sub, mult, and div");

		}
	}
}
