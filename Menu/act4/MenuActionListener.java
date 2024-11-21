import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

	public class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(MenuExample.frame,
				"Got an ActionEvent at" + new Date(e.getwhen())	+ "from" + e.getSource().getclass());
	}
}
