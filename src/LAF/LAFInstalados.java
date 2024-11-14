package LAF;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class LAFInstalados
{
	public static void main(String[] args) 
	{
		//Visualización de los diferentes Look And Feel disponibles en el sistema
		LookAndFeelInfo info[] = UIManager.getInstalledLookAndFeels();
		for(LookAndFeelInfo look:info)
			System.out.println(look.getClassName());
	}
} 