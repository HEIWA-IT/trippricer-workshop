#!/bin/bash
################################################################################
#                       start_exposition_locally.sh                            #
#                                                                              #
# This script goal is to check the variable use in the pipeline.               #
#                                                                              #
# Change History                                                               #
# 22/03/2022  Dan MAGIER           Script to start the exposition application  #
#                                                                              #
#                                                                              #
#                                                                              #
################################################################################
################################################################################
################################################################################
#                                                                              #
#  Copyright (C) 2007, 2022 Dan MAGIER                                         #
#  dan@heiwa-it.com                                                            #
#                                                                              #
#  This program is free software; you can redistribute it and/or modify        #
#  it under the terms of the GNU General Public License as published by        #
#  the Free Software Foundation; either version 2 of the License, or           #
#  (at your option) any later version.                                         #
#                                                                              #
#  This program is distributed in the hope that it will be useful,             #
#  but WITHOUT ANY WARRANTY; without even the implied warranty of              #
#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the               #
#  GNU General Public License for more details.                                #
#                                                                              #
#  You should have received a copy of the GNU General Public License           #
#  along with this program; if not, write to the Free Software                 #
#  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA   #
#                                                                              #
################################################################################
################################################################################
################################################################################


#######################################
# start the exposition application
#######################################
function start_exposition_locally() {
  cd exposition
  ../mvnw clean -Dmaven.test.skip=true -DskipTests spring-boot:run
}

################################################################################
################################################################################
# Main program                                                                 #
################################################################################
start_exposition_locally