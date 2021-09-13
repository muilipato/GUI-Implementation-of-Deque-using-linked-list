
import com.sun.xml.internal.ws.util.StringUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class GraphicalDisplay implements ActionListener {

    //private static int size;//introduced
    private final JPanel panel = new JPanel();
    private final JPanel btnPanel = new JPanel();
    private final  JButton btnRemoveFirst = new JButton("REMOVE FIRST");
    private final  JButton btnRemoveLast = new JButton("REMOVE LAST");
    private final JButton btnAddFirst = new JButton("ADD FIRST");
    private final JButton btnAddLast = new JButton("ADD LAST");
    private final JButton btnFirst = new JButton("FIRST");
    private final JButton btnLast = new JButton("LAST");
    private final JButton btnEmpty = new JButton("EMPTY");
    private final JButton btnSize = new JButton("SIZE");
    private String StringPositionToAdd;
    private int position;
    protected Random random = new Random();
    private JFrame frame;
    private final RestarauntEntrance linkedListStack;

    public GraphicalDisplay() {
        linkedListStack = new RestarauntEntrance();
    }

    protected void createAndShowGui(){
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(btnPanel);

        btnPanel.add(btnRemoveFirst);
        btnPanel.add(btnRemoveLast);
        btnPanel.add(btnAddFirst);
        btnPanel.add(btnAddLast);
        btnPanel.add(btnFirst);
        btnPanel.add(btnLast);
        btnPanel.add(btnEmpty);
        btnPanel.add(btnSize);

        btnRemoveFirst.addActionListener(this);
        btnRemoveLast.addActionListener(this);
        btnAddFirst.addActionListener(this);
        btnAddLast.addActionListener(this);
        btnFirst.addActionListener(this);
        btnLast.addActionListener(this);
        btnEmpty.addActionListener(this);
        btnSize.addActionListener(this);

        frame = new JFrame();
        frame.setTitle("Deque Implementation GUI ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel, BorderLayout.PAGE_END);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setSize(500, 400);
        frame.pack();
    }

    private void getSize(){
        JOptionPane.showMessageDialog(null,
                "SIZE: " + linkedListStack.size() ,
                "SIZE", 1 );
    }

    public void checkEmpty() {
        JOptionPane.showMessageDialog(null, StringUtils.capitalize(String.valueOf(linkedListStack.isEmpty())), "Empty", 1);
    }

   // private void checkEmpty(){
   //  JOptionPane.showMessageDialog(null, StringUtils.capitalize(String.valueOf(stackArray.isEmpty())), "Empty", 1);
      //  JOptionPane.showMessageDialog(null, "FALSE");
   // }

    private void getFirst() throws Deque.StackEmptyException, CloneNotSupportedException {
        JOptionPane.showMessageDialog(null,
                ((DrawRectangle)linkedListStack.first()).clone(), "FIRST",1);
    }





    private void getLast() throws Deque.StackEmptyException, CloneNotSupportedException {
        JOptionPane.showMessageDialog(null,
                ((DrawRectangle)linkedListStack.last()).clone(), "LAST",1);
    }

    private void addFirst(){
        float red = random.nextFloat();
        float green = random.nextFloat();
        float blue = random.nextFloat();
        final DrawRectangle drawRect = new DrawRectangle(new Color(red, green, blue));
        drawRect.setBorder(new LineBorder(Color.BLACK));
        linkedListStack.addFirst(drawRect);
        panel.add(drawRect, 0);
    }

    private void addLast(){
        float red = random.nextFloat();
        float green = random.nextFloat();
        float blue = random.nextFloat();
        final DrawRectangle drawRect = new DrawRectangle(new Color(red, green, blue));
        drawRect.setBorder(new LineBorder(Color.BLACK));
        linkedListStack.addLast(drawRect);
        panel.add(drawRect, linkedListStack.size());
    }

    public void removeFirst() throws Deque.StackEmptyException{
        DrawRectangle top = ((DrawRectangle) linkedListStack.first());
        panel.remove(top);
        linkedListStack.removeFirst();
        JOptionPane.showMessageDialog(null,
                top, "ELEMENT REMOVED", 1);
    }

    public void removeLast() throws Deque.StackEmptyException{
        DrawRectangle top = ((DrawRectangle) linkedListStack.last());
        panel.remove(top);
        linkedListStack.removeLast();
        JOptionPane.showMessageDialog(null,
                top, "ELEMENT REMOVED", 1);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if ("ADD FIRST".equals(actionEvent.getActionCommand())){
            addFirst();
        }

        if ("ADD LAST".equals(actionEvent.getActionCommand())){
            addLast();
        }

        if ("FIRST".equals(actionEvent.getActionCommand())){
            try{
                getFirst();
            }catch (Deque.StackEmptyException | CloneNotSupportedException ex){
                JOptionPane.showMessageDialog(null,
                        ex.getMessage(), "ERROR", 0);
            }
        }

        if ("LAST".equals(actionEvent.getActionCommand())){
            try{
                getLast();
            }catch (Deque.StackEmptyException | CloneNotSupportedException ex){
                JOptionPane.showMessageDialog(null,
                        ex.getMessage(), "ERROR", 0);
            }
        }

        if ("REMOVE FIRST".equals(actionEvent.getActionCommand())) {
            try {
                removeFirst();
            } catch (Deque.StackEmptyException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }

        if ("REMOVE LAST".equals(actionEvent.getActionCommand())) {
            try {
                removeLast();
            } catch (Deque.StackEmptyException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }

        if ("EMPTY".equals(actionEvent.getActionCommand())){
            checkEmpty();

        }

        if ("SIZE".equals(actionEvent.getActionCommand())){
            getSize();
        }


        frame.pack();
        frame.setLocationRelativeTo(null);
    }
}
