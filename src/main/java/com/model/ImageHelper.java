package com.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class ImageHelper {
    public static ImageView getImage(String url, Class c) {
        if (url == null)
            return null;
        Image image = new Image(c.getResource("/com/images/" + url).toExternalForm());

        ImageView backgroundImage = new ImageView(image);
        backgroundImage.setFitWidth(120);
        backgroundImage.setFitHeight(120);
        backgroundImage.setPreserveRatio(false);

        Rectangle clip = new Rectangle(120, 120);
        clip.setArcWidth(20);
        clip.setArcHeight(20);
        backgroundImage.setClip(clip);

        return backgroundImage;
    }
}
