package Font_Design_change_V_2;

import javax.swing.JFrame;

/**
 * Created by mkaroune on 28/01/18.
 */
public class FontPropertiesFrame extends SampleTextFrame
{
    public static void main(String[] args)
    {
        FontPropertiesFrame lSampleTextFrame = new FontPropertiesFrame();
        lSampleTextFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lSampleTextFrame.setVisible(true);
    }

    public FontPropertiesFrame()
    {
        super();
        FontPropertiesPanel lFontPropertiesPanel = (FontPropertiesPanel) propertiesPanel;
        displayedArea.setFont(lFontPropertiesPanel.getSelectedFont());
        lFontPropertiesPanel.setFontListener(this);
    }

    @Override
    protected void createComponents()
    {
        propertiesPanel = new FontPropertiesPanel();
        super.createComponents();
    }
}
