import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DrawObjects {
	public ImageView drawPlayer(String namePhoto, int setfh, int setfw, int x, int y) {
		Image playerIMG = new Image(namePhoto);
		ImageView player = new ImageView(playerIMG);
		player.setFitHeight(setfh);
		player.setFitWidth(setfw);
		player.setLayoutX(x);
		player.setLayoutY(y);
		return player;
	}

	public ImageView drawFootball(String namePhoto, int setfh, int setfw, int x, int y, double opac) {
		Image footballIMG = new Image(namePhoto);
		ImageView football = new ImageView(footballIMG);
		football.setFitHeight(setfh);
		football.setFitWidth(setfw);
		football.setLayoutX(x);
		football.setLayoutY(y);
		football.setOpacity(opac);
		return football;
	}
}