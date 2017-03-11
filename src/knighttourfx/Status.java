/*
 * The MIT License
 *
 * Copyright 2017 mhrimaz.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package knighttourfx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author mhrimaz
 */
public class Status {

    private final StringProperty status = new SimpleStringProperty();

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String value) {
        status.set(value);
    }

    public StringProperty statusProperty() {
        return status;
    }

    private final LongProperty takenTime = new SimpleLongProperty();

    public long getTakenTime() {
        return takenTime.get();
    }

    public void setTakenTime(long value) {
        takenTime.set(value);
    }

    public LongProperty takenTimeProperty() {
        return takenTime;
    }

    private final IntegerProperty visitedNode = new SimpleIntegerProperty();

    public int getVisitedNode() {
        return visitedNode.get();
    }

    public void setVisitedNode(int value) {
        visitedNode.set(value);
    }

    public IntegerProperty visitedNodeProperty() {
        return visitedNode;
    }

    private final IntegerProperty currentMoveDepth = new SimpleIntegerProperty();

    public int getCurrentMoveDepth() {
        return currentMoveDepth.get();
    }

    public void setCurrentMoveDepth(int value) {
        currentMoveDepth.set(value);
    }

    public IntegerProperty currentMoveDepthProperty() {
        return currentMoveDepth;
    }

    private final IntegerProperty expandedNode = new SimpleIntegerProperty();

    public int getExpandedNode() {
        return expandedNode.get();
    }

    public void setExpandedNode(int value) {
        expandedNode.set(value);
    }

    public IntegerProperty expandedNodeProperty() {
        return expandedNode;
    }

}
