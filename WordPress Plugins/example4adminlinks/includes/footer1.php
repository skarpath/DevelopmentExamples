<?php

//Function to replace footer string
function wpCustomfooter( $footer ){
  $new_footer = str_replace   ('.</span>', __(' and <a href="stephenkarpath.com">stephen K</a>.</span>', 'wpplugin'), $footer);

  return $new_footer;
}

//Runs this function for admin menu text
add_filter('admin_footer_text', 'wpCustomfooter', 10,1);
