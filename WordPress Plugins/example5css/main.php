<?php
/*
Plugin Name:  example5css
Plugin URI:   https://developer.wordpress.org/plugins/the-basics/
Description:  example5 css example
Version:      0.0.1
Author:       Stephen K
Author URI:   stephenkarpath.com
License:      GPLV2 or Later
License URI:  https://www.gnu.org/licenses/gpl-2.0.html
Text Domain:  wpplugin
Domain Path:  /languages
*/

//If the following plugin is already defined, then quit
if ( ! defined ( 'WPINC')){
  die;
}

define('WPPLUGIN_URL', plugin_dir_url(  __FILE__  ) );

include( plugin_dir_path ( __FILE__ ) . 'includes/example5css-styles.php');

include( plugin_dir_path ( __FILE__ ) . 'includes/example5css-menu.php');
