/*
 * ServerWrecker
 *
 * Copyright (C) 2022 ServerWrecker
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 */
package net.pistonmaster.serverwrecker.gui.navigation;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import net.pistonmaster.serverwrecker.ServerWrecker;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

public class DeveloperPanel extends NavigationItem {
    public static final JCheckBox debug = new JCheckBox();

    public DeveloperPanel() {
        super();

        setLayout(new GridLayout(0, 2));

        add(new JLabel("Debug: "));
        add(debug);

        debug.addActionListener(listener -> {
            if (debug.isSelected()) {
                ServerWrecker.getInstance().setupDebug();
            } else {
                ServerWrecker.getInstance().setupInfo();
            }
        });
    }

    @Override
    public String getNavigationName() {
        return "Developer Tools";
    }

    @Override
    public String getRightPanelContainerConstant() {
        return RightPanelContainer.DEV_MENU;
    }
}
