/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package image.handling;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.StreamSupport;

/**
 *
 * @author nour
 */
public class ImageHandling {
    public static String[] splitPath(String pathString) {
        Path path = Paths.get(pathString);
        return StreamSupport.stream(path.spliterator(), false).map(Path::toString)
                .toArray(String[]::new);
    }
    
}
