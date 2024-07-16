import javax.swing.JOptionPane;


public class TutorialTwo {

	public static void main(String[] args) {

		int answer = JOptionPane.showConfirmDialog(null, "Is the planet habitable?");
		
		if (answer  == JOptionPane.YES_OPTION)  {
			answer = JOptionPane.showConfirmDialog(null, "Does the animal have cold blood?");
			if (answer == JOptionPane.YES_OPTION) {
				answer = JOptionPane.showConfirmDialog(null, "Does the animal have scales?"); 
				if (answer == JOptionPane.YES_OPTION) {
					answer = JOptionPane.showConfirmDialog(null, "Does the animal have fins?");
					if (answer == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "The animal is a fish.");
					}
					else {
						JOptionPane.showMessageDialog(null, "The animal is a reptile.");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "The animal is an amphibian.");
				}
			}
			else {
				answer = JOptionPane.showConfirmDialog(null, "Does the animal have feathers?"); 
				if (answer == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "The animal is a bird.");
				}
				else {
					JOptionPane.showMessageDialog(null, "The animal is a mammal.");
				}
			}
		}
		
		
		
		else {
			JOptionPane.showMessageDialog(null, "This animal does not exist.");
		}

	}

}
