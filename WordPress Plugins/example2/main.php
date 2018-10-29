<?php
/*
Plugin Name:  example2
Plugin URI:   https://developer.wordpress.org/plugins/the-basics/
Description:  Will replace admin footer text
Version:      0.0.1
Author:       Stephen K
Author URI:   stephenkarpath.com
License:      GPLV2 or Later
License URI:  https://www.gnu.org/licenses/gpl-2.0.html
Text Domain:  wporg
Domain Path:  /languages
*/

//If the following plugin is already defined, then quit
if ( ! defined ( 'WPINC')){
  die;
}

//Add menu settings
function example2_settings_page()
{
   add_menu_page(
    'Plugin name',
    'Plugin Menu',
    'manage_options',
    'example2',
    'example2_settings_markup',
    'dashicons-wordpress-alt',
    100
  );
}

add_action( 'admin_menu' , 'example2_settings_page' );

function example2_settings_markup(){
   //Double check user caplities
   if ( !current_user_can('manage_options' ) ) {
     return;
   }
   ?>
   <div class="wrap">
      <h1><?php esc_html_e( get_admin_page_title() ); ?></h1>
      <p><?php esc_html_e( 'Some content.'); ?></p>
   </div>
   <?php


}
?>
