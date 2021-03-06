package SAIO.Lab13;
import static java.lang.Math.*;

public class Lab_131 {
	static double f(double x)
	{
		double h = 3.89, g = 8.433, f1, f2, f3, y;
				f1 = abs(pow((x - h), 2) * sin(x - g) - 0.59) * 15.5;
				f2 = sqrt(2 + log10(1 + pow(x, 2) + exp(x + 1)));
				f3 = sqrt(1 + log10(1 + pow((2 * x), 2)));
				y = (f1 / f2) * f3;
		return y;
	}
	
	static double ZolSech_MAX(double a, double b) {
		double phi, x1, x2, f1, f2;
		phi = (1 + sqrt(5)) / 2; /* ��������� �������� ������� */
		
		/*��������� ������� ����� ������������� ������������ ��� ������ ������� */
		x1 = b - (b - a) / phi; 
		x2 = a + (b - a) / phi;
		
		f1 = f(x1); 
		f2 = f(x2);
		
		/* ����������� ��� �� ������ �������, 
		� �������� �� ���� ����� ������������ ����� ����� ��������� ��, 
		�������� � ������� ����������o */
		while (abs(b - a) > E) { 
			if (f1 <= f2) { 
				a = x1; 
				x1 = x2; 
				f1 = f2; 
				x2 = a + (b - a) * phi; 
				f2 = f(x2); 
			} 
			else { 
				b = x2; 
				x2 = x1; 
				f2 = f1; 
				x1 = b - (b - a) * phi; 
				f1 = f(x1); 
			}  
		}
		return (a + b) / 2;	
	}
	
	static double ZolSech_MIN(double a, double b) {
		double phi, x1, x2, f1, f2;
		phi = (1 + sqrt(5)) / 2; /* ��������� �������� ������� */
		
		/*��������� ������� ����� ������������� ������������ ��� ������ ������� */
		x1 = b - (b - a) / phi; 
		x2 = a + (b - a) / phi;
		
		f1 = f(x1); 
		f2 = f(x2);
		
		/* ����������� ��� �� ������ �������, 
		� �������� �� ���� ����� ������������ ����� ����� ��������� ��, 
		�������� � ������� ����������o */
		while (abs(b - a) > E) { 
			if (f1 >= f2) { 
				a = x1; 
				x1 = x2; 
				f1 = f2; 
				x2 = a + (b - a) * phi; 
				f2 = f(x2); 
			} 
			else { 
				b = x2; 
				x2 = x1; 
				f2 = f1; 
				x1 = b - (b - a) * phi; 
				f1 = f(x1); 
			}  
		}
		return (a + b) / 2;	
	}
	
	public static void main(String[] args) {
		double []fx = new double [21];
		double a = (double) 1.2, b = (double) 3.8, x = a, t = ((b - a) / 20), xmin, xmax;
		int j;

   		for (j = 0; j <= 20; j++) {
   			if (x <= b) {
   			fx[j] = f(x);
			System.out.println("  x =" + String.format("%5.2f", x).replace(',', '.') + " | f(x)  = " + String.format("%7.4f", fx[j]).replace(',', '.'));
   			x += t;
   		}
   	}

		for (j = 0, x = a;j < 18; j++, x += t) {
			if (fx[j] <= fx[j + 1] && fx[j + 1] >= fx[j + 2]){
				xmax = ZolSech_MAX(x, (x + 2 * t));
				System.out.println("�� ������� [" + String.format("%4.2f", x).replace(',', '.') + ";" + String.format("%4.2f", (x+2*t)).replace(',', '.') + "] - max |x* = "	+ String.format("%5.2f", xmax).replace(',', '.') + " | F(x*) = "	+ String.format("%5.4f", f(xmax)).replace(',', '.'));
				
			} 
			if (fx[j] >= fx[j + 1] && fx[j + 1] <= fx[j + 2]) {
				xmin = ZolSech_MIN(x, (x + 2 * t));
				System.out.println("�� ������� [" + String.format("%4.2f", x).replace(',', '.') + ";" + String.format("%4.2f", (x+2*t)).replace(',', '.') + "] - min |x* = " + String.format("%5.2f", xmin).replace(',', '.') + " | F(x*) = "	+ String.format("%5.6f", f(xmin)).replace(',', '.'));
			}
		}
	}
}
