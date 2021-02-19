package org.example;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class BouncyBallPane extends Pane {

  private List<Ball> ballList;
  private int numBalls;
  private Color selectedColor;

  private class Ball{
    Circle circle;
    int indX, indY;

    public Ball(double width, double height, double radius, Color selectedColor) {
      double x = Math.random() * (width - 2 * radius) + radius;
      double y = Math.random() * (height - 2 * radius) + radius;
      if(selectedColor == null){
        selectedColor = new Color(Math.random(), Math.random(), Math.random(), 1);
      }
      circle = new Circle(x, y, radius, selectedColor);
      indX = Math.random() < 0.5 ? -1: 1;
      indY = Math.random() < 0.5 ? -1: 1;
    }
  }

  public BouncyBallPane(int numBalls, Color selectedColor) {
    this.ballList = new ArrayList<>();
    this.numBalls= numBalls;
    this.selectedColor = selectedColor;
  }

  public void generateBalls(){
    double width = this.getWidth();
    double height = this.getHeight();
    double radius = Math.min(width, height)/20;

    for(int i = 0; i < numBalls; i++){
      Ball ball = new Ball(width, height, radius, selectedColor);
      this.getChildren().add(ball.circle);
      ballList.add(ball);
    }

    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(40),
        actionEvent -> moveBalls()));
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();
  }

  public void moveBalls(){
    double dispX = this.getWidth()/40;
    double dispY = this.getHeight()/40;

    for(Ball b : ballList){
      double newX = b.circle.getCenterX() + dispX*b.indX;
      if(newX < b.circle.getRadius() || newX > this.getWidth() - b.circle.getRadius()){
        b.indX = -b.indX;
        // this will change color of the ball when it hits the wall only if random color is selected
        if(this.selectedColor == null)
          b.circle.setFill(changeColor());
        newX += dispX * b.indX;
      }
      double newY = b.circle.getCenterY() + dispY * b.indY;
      if(newY < b.circle.getRadius() || newY > this.getHeight() - b.circle.getRadius()){
        b.indY = -b.indY;
        // this will change color of the ball when it hits the wall only if random color is selected
        if(this.selectedColor == null)
          b.circle.setFill(changeColor());
        newY += dispY * b.indY;
      }
      b.circle.setCenterX(newX);
      b.circle.setCenterY(newY);
    }
  }
  public Color changeColor(){
    Color newColor = new Color(Math.random(), Math.random(), Math.random(),1);
    return newColor;
  }
}
