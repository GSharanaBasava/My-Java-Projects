package Calculator.c1;

public interface Calculator {
	int add(int x,int y);
	int sub(int x,int y);
	int div(int x,int y);
	int mul(int x,int y);
	String displayErrorMessage();

}
//all the above methods are automatically public and abstract