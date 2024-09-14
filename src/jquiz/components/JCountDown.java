/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz.components;

import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author ratul
 */
public class JCountDown extends JLabel {

    private static final DateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("HH:mm:ss.SSS");

    static {
        DEFAULT_DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    private boolean countUp = false;
    private long duration = 0;
    private long pausedDuration = 0;
    private DateFormat dateFormat = DEFAULT_DATE_FORMAT;

    private java.awt.event.ActionListener actionListener;

    private long pauseTime = -1;

    private long startTime;
    private Timer timer;

    public boolean isCountUp() {
        return countUp;
    }

    public void setCountUp(boolean countUp) {
        this.countUp = countUp;
    }

    public void setDuration(long duration) {
        this.duration = duration * 1000000;
        setText(dateFormat.format(duration));
    }

    public long getDuration() {
        return duration / 1000000;
    }

    public long getPausedDuration() {
        long currentPausedDuration = this.pausedDuration;
        if (pauseTime != -1) {
            currentPausedDuration += System.nanoTime() - pauseTime;
        }
        return currentPausedDuration / 1000000;
    }

    public void setDateFormat(String pattern) {
        DateFormat currentDateFormat = new SimpleDateFormat(pattern);
        currentDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        setDateFormat(currentDateFormat);
    }

    public void setDateFormat(DateFormat dateFormat) {
        if (dateFormat == null) {
            dateFormat = DEFAULT_DATE_FORMAT;
        }
        this.dateFormat = dateFormat;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setActionListener(java.awt.event.ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public void setPaused(boolean paused) {
        if (paused) {
            if (pauseTime == -1) {
                pauseTime = System.nanoTime();

                timerStop();
            }
        } else {
            if (pauseTime != -1) {
                pausedDuration += System.nanoTime() - pauseTime;
                pauseTime = -1;

                timerStart();
            }
        }
    }

    public boolean isPaused() {
        return pauseTime != -1;
    }

    public void start() {
        timerStop();

        pausedDuration = 0;
        pauseTime = -1;

        timer = new Timer(10, (ActionEvent e) -> {
            if (pauseTime == -1) {
                long elapsedTime = System.nanoTime() - startTime - pausedDuration;
                if (elapsedTime >= duration) {
                    elapsedTime = duration;
                    timer.stop();
                }
                if (!countUp) {
                    elapsedTime = duration - elapsedTime;
                }
                setText(dateFormat.format(elapsedTime / 1000000));
                if (!timer.isRunning() && actionListener != null) {
                    actionListener.actionPerformed(new java.awt.event.ActionEvent(this, 0, ""));
                }
            }
        });
        timer.setInitialDelay(0);

        startTime = System.nanoTime();
        timer.start();
    }

    public void stop() {
        timerStop();
    }

    private void timerStart() {
        if (timer != null) {
            timer.start();
        }
    }

    private void timerStop() {
        if (timer != null) {
            timer.stop();
        }
    }
}
