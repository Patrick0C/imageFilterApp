README

Image Filtering System
Patrick O'Carroll - G00398246
HDip Software Development - Object Orientated Software Development

--------------
Files Included
--------------
1. src			Containing all source files to run this application including 
			imageOutput, the directory where the filtered image will be written to
2. Images 		A folder containing potential images for the user to choose from
3. README.txt		This README file

--------
Features
--------

1. Menu 
On running this application, the user will be presented with the main menu. 
From here, they can navigate to five seperate options using the corrisponding 
numeric input as a selection tool. 

They can: choose an image, be presented with 
all the filter options to choose from which includes an option to return to the 
main menu without selecting an option, an additional options menu where the user 
will be brought to a submenu asking them if they want to navigate to see all 
brightness/ image intensity options or return to the main menu without selecting
a choice, an option to apply all selected options to the image which will subsequently
write a new image, and finally an option to shutdown the entire application.

On each option selection (i.e a valid filepath was entered/ the box filter was selected) 
the user will be notified which option they have chosen and that, if successful, that 
the selection was a success. Each "INFO" message is highlighted in underline green to
display the successful action that has taken place.

If the user inputs an integer that is not an option for that particular selection, they 
will be prompted with an error message alerting them to what integer they have input and 
what integers are applicable for that menu. These type of "ERROR" messages are written 
in underline red to signify that the desired action has not taken place.


2. Image Selection
Oce in the image selection menu, a user must enter a valid image filepath in order for 
the image to be successfully read 
e.g C:\Users\patrick\OneDrive\Desktop\Project\Images\bridge-gs.png

On successful reading of the image, this image will be written unaltered if no further 
options (filters/ brightness) are selected.


3. Writing the Image
Once a user has selected all options they wish to apply to the read image, to write the 
image the user selections option 4 on the main menu. This is done in order to allow a 
user to change their mind about what filter was selected if an incorrect selection was made.
This newly filtered image will be saved to /imageOutput/out.png within the src directory.


4. Image Brightness 
Within the image brightness menu, a user can choose to adjust the image brightness based
off of a percentage of the original images brightness. A user can adjust this 
from -50% to +50% of the images original brightness. This is achieved by applying the 
selection as a multiplier to the ARGB values once a pixel has had a filter applied to it.
To avoid going beyond the 0 - 255 limits of an ARGB value, the result is checked against 
both of these extremes and is only returned if it is within 0 - 255.

If no brightness option is selected, the defaault will be 1, resulting in the default image
brightness being returned.


5. Filter Intensity
Similar to the brightness option, within the filter intensity menu, a user can choose to 
adjust the filter intensity based off of a percentage of the default filter 2D array values.
A user can adjust this from -50% to +50% of the filter's original values. This is achieved 
by adding the selection to each specific value of the filter's 2D array before it is applied 
to each RGB value of each pixel of the selected image.

If no filter intensity option is selected, the default will be 0, resulting in the default 
filter intensity being applied.


6. Filter Selection
In the filter selection menu, a user is prompted to select one of eleven different filter options.
Once selected, a filter choice can be changed before applying it to the image, however, once the new 
image is written and the user is presented with the main menu again, if a valid image filepath is
not re-entered, and the user selects a filter to apply, this will write the same image but now with 
the effect of layring filters on top of one another resulting in many new different combinations 
and effects.

If no filter option is selected, the Identity filter will be used by default resulting in the original
image being returned without any physical change.


