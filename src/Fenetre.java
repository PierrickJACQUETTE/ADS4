import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Fenetre extends JFrame {

	private JPanel dessin;

	public Fenetre() {
		JFrame contenu = new JFrame("Dessin");
		int decalageY = 44;
		int decalageX = 6;
		contenu.setSize(Instruction.largeurFenetre + decalageX + 1,
				Instruction.hauteurFenetre + decalageY + 1);

		final Panneau dessin = new Panneau(contenu.getWidth() - decalageX,
				contenu.getHeight() - decalageY);

		final JSlider slider = new JSlider(0, 100, 0);
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				dessin.setZoom(5. * slider.getValue() / slider.getMaximum() + 1);
			}
		});

		contenu.add(slider, BorderLayout.NORTH);
		contenu.add(new JScrollPane(dessin));
		contenu.setLocation(150, 150);
		contenu.setVisible(true);
		contenu.setResizable(false);
		contenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
