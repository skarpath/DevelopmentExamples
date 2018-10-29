<?php
/*
Plugin Name:  example3Submenu
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
function example3_settings_page()
{
   add_menu_page(
    __('Plugin name', 'example3' ),
    __('Plugin Menu', 'example3' ),
    'manage_options',
    'example3',
    'example3_settings_markup',
    'dashicons-wordpress-alt',
    100
  );

  add_submenu_page(
   'example3', //Page you want it on
   __('Plugin name', 'example3' ),
   __('Item 1', 'example3' ),
   'manage_options',
   'example3-item-1', //SLUG
   'example3_settings_subpage_markup'
   );


}

add_action( 'admin_menu' , 'example3_settings_page' );

function example3_settings_markup(){
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

function example3_settings_subpage_markup(){
   //Double check user caplities
   if ( !current_user_can('manage_options' ) ) {
     return;
   }
   ?>
   <div class="wrap">
      <h1><?php esc_html_e( get_admin_page_title() ); ?></h1>
      <p><?php esc_html_e( 'Some content. Page 2'); ?></p>
   </div>
   <?php


}







// Add submenu to default WordPress menu------
function example3_settings_default_submenu(){
  // Can add sub menu to admin pages using the following
  // add_dashboard_page()
  // add_posts_page()
  // add_media_page()
  // add_pages_page()
  // add_comments_page()
  // add_plugins_page
  // add_users_page
  // add_management_page()
  // add_options_page()

  add_theme_page(   //Menu type display
    __('Custom Subpage','example3'), //Page title
    __('Custom Sub Page', 'example3'), //menu title
    'manage_options',  //options
    'example3-subpage', //slug
    'example3_settings_subpage_markup', //Callback function for page markup
    'dashicons-wordpress-alt', //Icons
    100 //Order
  );
}
add_action('admin_menu', 'example3_settings_default_submenu');











?>
