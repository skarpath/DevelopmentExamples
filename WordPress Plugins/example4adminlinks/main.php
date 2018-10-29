<?php
/*
Plugin Name:  example4adminlinks
Plugin URI:   https://developer.wordpress.org/plugins/the-basics/
Description:  example4adminlinks
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
function example4_settings_page()
{
   add_menu_page(
    __('Plugin name', 'example4' ),
    __('Plugin Menu', 'example4' ),
    'manage_options',
    'example4',
    'example4_settings_markup',
    'dashicons-wordpress-alt',
    100
  );

  add_submenu_page(
   'example4', //Page you want it on
   __('Plugin name', 'example4' ),
   __('Item 1', 'example4' ),
   'manage_options',
   'example4-item-1', //SLUG
   'example4_settings_subpage_markup'
   );


}

add_action( 'admin_menu' , 'example4_settings_page' );

function example4_settings_markup(){
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

function example4_settings_subpage_markup(){
   //Double check user caplities
   if ( !current_user_can('manage_options' ) ) {
     return;
   }
   ?>
   <div class="wrap">
      <h1><?php esc_html_e( get_admin_page_title() ); ?></h1>
      <p><?php esc_html_e( 'Some content. Page 2'); ?></p>

      <ul>
        <li>
          Plugin_url(__FILE__) -
          <?php
          $wp_path = plugin_dir_url(__FILE__);
          echo $wp_path;
          ?>
        </li>
      </ul>
   </div>
   <?php


}







// Add submenu to default WordPress menu------
function example4_settings_default_submenu(){
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
    __('Custom Subpage','example4'), //Page title
    __('Custom Sub Page', 'example4'), //menu title
    'manage_options',  //options
    'example4-subpage', //slug
    'example4_settings_subpage_markup', //Callback function for page markup
    'dashicons-wordpress-alt', //Icons
    100 //Order
  );
}
add_action('admin_menu', 'example4_settings_default_submenu');




//Add link to settings plugin Menu
function example4_add_settings_link( $links ){

  $settings_link = '<a href="admin.php?page=example4">' . __('Settings') . '</a>';
  array_push($links, $settings_link);
  return $links;
}

$filter_name = "plugin_action_links_" . plugin_basename( __FILE__ );
add_filter($filter_name, 'example4_add_settings_link');









?>
