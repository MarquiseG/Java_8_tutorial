package Font_Design_change_V_1;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 * ***************************************************************************
 * <p>
 * $RCSfile: Font_Design_change_V_1.FontPropertiesPanel.java,v $
 * <p>
 * <p>
 * <p>
 * ***************************************************************************
 * <p>
 * $Revision: 1.0 $
 * <p>
 * $Id: Font_Design_change_V_1.FontPropertiesPanel.java,v 2018/01/21 22:44 mkaroune Exp $
 * <p>
 * ***************************************************************************
 * <p>
 * Copyright (c) 2018 Nokia . All Rights Reserved.
 * Please read the associated COPYRIGHTS file for more details.
 * <p>
 * ***************************************************************************
 */

public class FontPropertiesPanel extends JPanel
{
    protected JList<String> nameList;
    protected JComboBox<Integer> sizeBox;
    protected JCheckBox boldBox;
    protected JCheckBox italicBox;
    protected SampleTextFrame frame;

    public final static int[] fontSizes = {10, 12, 14, 18, 24, 32, 48, 64};


    public FontPropertiesPanel(SampleTextFrame aInSampleTextFrame)
    {
        super();
        frame = aInSampleTextFrame;
        createComponents();
        buildLayout();
    }

    protected void buildLayout()
    {
        JLabel lJLabel;
        GridBagLayout lGridBagLayout = new GridBagLayout();
        GridBagConstraints lConstraints = new GridBagConstraints();
        setLayout(lGridBagLayout);

        lConstraints.anchor = GridBagConstraints.WEST;
        lConstraints.insets = new Insets(5, 10, 5, 10);

        lConstraints.gridx = 0;
        lJLabel = new JLabel("Name : ", JLabel.LEFT);
        lGridBagLayout.setConstraints(lJLabel, lConstraints);
        add(lJLabel);
        lJLabel = new JLabel("Size :", JLabel.LEFT);
        lGridBagLayout.setConstraints(lJLabel, lConstraints);
        add(lJLabel);
        lGridBagLayout.setConstraints(boldBox, lConstraints);
        add(boldBox);

        lConstraints.gridx++;
        nameList.setVisibleRowCount(3);
        JScrollPane lScrollPane = new JScrollPane(nameList);
        lGridBagLayout.setConstraints(lScrollPane, lConstraints);
        add(lScrollPane);
        lGridBagLayout.setConstraints(sizeBox, lConstraints);
        add(sizeBox);
        lGridBagLayout.setConstraints(italicBox, lConstraints);
        add(italicBox);
    }

    protected void createComponents()
    {
        GraphicsEnvironment lGraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] lAvailableFontFamilyNames = lGraphicsEnvironment.getAvailableFontFamilyNames();

        nameList = new JList<>(lAvailableFontFamilyNames);
        nameList.setSelectedIndex(0);
        nameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        nameList.addListSelectionListener(e -> handleFontPropertyChange());

        Integer sizes[] = new Integer[fontSizes.length];
        for (int i = 0; i < sizes.length; i++)
        {
            sizes[i] = fontSizes[i];
        }
        sizeBox = new JComboBox<>(sizes);
        sizeBox.addActionListener(e -> handleFontPropertyChange());

        boldBox = new JCheckBox("Bold");
        boldBox.addActionListener(e -> handleFontPropertyChange());

        italicBox = new JCheckBox("Size");
        italicBox.addActionListener(e -> handleFontPropertyChange());
    }

    private void handleFontPropertyChange()
    {
        frame.refreshDisplayFont();
    }

    public String getSelectedFontNames()
    {
        return nameList.getSelectedValue();
    }

    public int getSelectedFontSize()
    {
        return (Integer) sizeBox.getSelectedItem();
    }

    public boolean isBoldSelected()
    {
        return boldBox.isSelected();
    }

    public boolean isItalicSelected()
    {
        return italicBox.isSelected();
    }
}
