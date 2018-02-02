package Font_Design_change_V_2;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 * ***************************************************************************
 * <p>
 * $RCSfile: Font_Design_change_V_1.SampleTextFrame.java,v $
 * <p>
 * <p>
 * <p>
 * ***************************************************************************
 * <p>
 * $Revision: 1.0 $
 * <p>
 * $Id: Font_Design_change_V_1.SampleTextFrame.java,v 2018/01/22 11:20 mkaroune Exp $
 * <p>
 * ***************************************************************************
 * <p>
 * Copyright (c) 2018 Nokia . All Rights Reserved.
 * Please read the associated COPYRIGHTS file for more details.
 * <p>
 * ***************************************************************************
 */

public class SampleTextFrame extends JFrame implements FontListener
{
    protected JPanel propertiesPanel;
    protected JTextField sampleText;
    protected JLabel displayedArea;


    public SampleTextFrame()
    {
        super();
        createComponents();
        createDocumentListener();
        buildLayout();
//        displayedArea.setFont(propertiesPanel.getSelectedFont());
//        propertiesPanel.setFontListener(this);
        pack();
    }

    private void buildLayout()
    {
        Container pane = getContentPane();
        GridBagConstraints constrains = new GridBagConstraints();
        GridBagLayout layout = new GridBagLayout();
        pane.setLayout(layout);

        constrains.insets = new Insets(5, 10, 5, 10);
        constrains.fill = GridBagConstraints.HORIZONTAL;
        constrains.weightx = 1;

        constrains.gridx = 0;
        BevelBorder bb = new BevelBorder(BevelBorder.RAISED);
        TitledBorder tb = new TitledBorder(bb, "Font");
        propertiesPanel.setBorder(tb);
        layout.setConstraints(propertiesPanel, constrains);
        pane.add(propertiesPanel);

        layout.setConstraints(sampleText, constrains);
        pane.add(sampleText);

        layout.setConstraints(displayedArea, constrains);
        pane.add(displayedArea);
    }

    private void createDocumentListener()
    {
        Document document = sampleText.getDocument();
        document.addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e)
            {
                handleDocumentUpdate();
            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                handleDocumentUpdate();
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {
                handleDocumentUpdate();
            }
        });
    }

    private void handleDocumentUpdate()
    {
        displayedArea.setText(sampleText.getText());
    }

    protected void createComponents()
    {
//        propertiesPanel = new FontPropertiesPanel(this);
        sampleText = new JTextField(20);
        displayedArea = new JLabel(" ");
        displayedArea.setPreferredSize(new Dimension(200, 75));
        displayedArea.setMaximumSize(new Dimension(200, 75));
    }

    @Override
    public void fontChanged(Font newFont)
    {
        displayedArea.setFont(newFont);
    }
}
