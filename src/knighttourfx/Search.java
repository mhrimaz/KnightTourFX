/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knighttourfx;

/**
 *
 * @author mhrimaz
 */
@FunctionalInterface
public interface Search {
    public ArrayState search(ArrayState initState,Status status);
}
