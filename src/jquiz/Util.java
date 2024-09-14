/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jquiz;

import java.awt.Component;
import java.awt.Container;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author ratul
 */
public abstract class Util {

    public static boolean all(boolean[] array) {
        return all(array, 0, array.length);
    }

    public static boolean all(boolean[] array, int start, int stop) {
        for (int index = start; index < stop; ++index) {
            if (!array[index]) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean all(T[] array, T value) {
        return all(array, value, 0, array.length);
    }

    public static <T> boolean all(T[] array, T value, int start, int stop) {
        for (int index = start; index < stop; ++index) {
            if (!value.equals(array[index])) {
                return false;
            }
        }
        return true;
    }

    public static boolean any(boolean[] array) {
        return any(array, 0, array.length);
    }

    public static boolean any(boolean[] array, int start, int stop) {
        for (int index = start; index < stop; ++index) {
            if (array[index]) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean any(T[] array, T value) {
        return any(array, value, 0, array.length);
    }

    public static <T> boolean any(T[] array, T value, int start, int stop) {
        for (int index = start; index < stop; ++index) {
            if (value.equals(array[index])) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean any(T[] array, T[] values) {
        return any(array, values, 0, array.length);
    }

    public static <T> boolean any(T[] array, T[] values, int start, int stop) {
        for (int index = start; index < stop; ++index) {
            for (T value : values) {
                if (value.equals(array[index])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static <T> boolean unique(T[] array) {
        return unique(array, 0, array.length);
    }

    public static <T> boolean unique(T[] array, int start, int stop) {
        HashSet<Object> hashSet = new HashSet<>(stop - start);
        for (int index = start; index < stop; ++index) {
            T element = array[index];
            if (hashSet.contains(element)) {
                return false;
            } else {
                hashSet.add(element);
            }
        }
        return true;
    }

    public static <T> int find(T[] array, T element) {
        return find(array, element, 0, array.length);
    }

    public static <T> int find(T[] array, T element, int start, int stop) {
        for (int index = start; index < stop; ++index) {
            if (element == array[index]) {
                return index;
            }
        }
        return -1;
    }

    public static <T> int count(T[] array, T element) {
        return count(array, element, 0, array.length);
    }

    public static <T> int count(T[] array, T element, int start, int stop) {
        int count = 0;
        for (int index = start; index < stop; ++index) {
            if (element == array[index]) {
                ++count;
            }
        }
        return count;
    }

    public static <T> Stream<T> stream(Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }

    public static <T> List<T> flatten(Iterable<Iterable<T>> iterables) {
        return stream(iterables).flatMap((Iterable<T> iterable) -> stream(iterable)).toList();
    }

    public static String sha1(String input) {
        MessageDigest sha1;
        try {
            sha1 = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException exception) {
            return null;
        }
        sha1.update(input.getBytes());
        byte[] digest = sha1.digest();

        StringBuilder hexDigest = new StringBuilder();
        for (byte part : digest) {
            hexDigest.append(String.format("%02x", part));
        }
        return hexDigest.toString();
    }

    public static ArrayList<LocalTime> getLocalTimes(LocalTime start, LocalTime stop, LocalTime step) {
        if (start == null) {
            start = LocalTime.MIN;
        }
        if (stop == null) {
            stop = LocalTime.MAX;
        }
        ArrayList<LocalTime> localTimes = new ArrayList<>();
        LocalTime localTime = start;
        while (localTime.compareTo(stop) < 0) {
            localTimes.add(localTime);
            localTime = localTime.plusHours(step.getHour())
                    .plusMinutes(step.getMinute())
                    .plusSeconds(step.getSecond())
                    .plusNanos(step.getNano());

        }
        return localTimes;
    }

    public static void setEnabled(Component component, boolean enabled) {
        component.setEnabled(enabled);
        if (component instanceof Container container) {
            for (Component child : container.getComponents()) {
                setEnabled(child, enabled);
            }
        }
    }

    public static void setTableWidth(JTable table) {
        TableColumnModel columnModel = table.getColumnModel();
        for (int columnIndex = 0; columnIndex < table.getColumnCount(); ++columnIndex) {
            int maxWidth = 0;
            for (int rowIndex = 0; rowIndex < table.getRowCount(); ++rowIndex) {
                TableCellRenderer cellRenderer = table.getCellRenderer(rowIndex, columnIndex);
                Object value = table.getValueAt(rowIndex, columnIndex);
                Component component = cellRenderer.getTableCellRendererComponent(
                        table, value, false, false, rowIndex, columnIndex);
                maxWidth = Math.max(component.getPreferredSize().width, maxWidth);
            }
            TableColumn column = columnModel.getColumn(columnIndex);
            TableCellRenderer headerRenderer = column.getHeaderRenderer();
            if (headerRenderer == null) {
                headerRenderer = table.getTableHeader().getDefaultRenderer();
            }
            Object headerValue = column.getHeaderValue();
            Component headerComponent = headerRenderer.getTableCellRendererComponent(
                    table, headerValue, false, false, 0, columnIndex);
            maxWidth = Math.max(maxWidth, headerComponent.getPreferredSize().width);
            column.setMinWidth(maxWidth);
            column.setPreferredWidth(maxWidth);
        }
    }
}
