<?php
/*
Plugin Name:  example6js
Plugin URI:   https://developer.wordpress.org/plugins/the-basics/
Description:  example6 Enqueuing js example
Version:      0.0.1
Author:       Stephen K
Author URI:   stephenkarpath.com
License:      GPLV2 or Later
License URI:  https://www.gnu.org/licenses/gpl-2.0.html
Text Domain:  example6js
Domain Path:  /languages
*/

//If the following plugin is already defined, then quit
if ( ! defined ( 'WPINC')){
  die;
}

define('WPPLUGIN_URL', plugin_dir_url(  __FILE__  ) );

//Enqueue styles
include( plugin_dir_path ( __FILE__ ) . 'includes/example6js-styles.php');

//Enqueue Plugin JS scrips
include( plugin_dir_path ( __FILE__ ) . 'includes/example6js-scripts.php');

//Enqueue Plugin JS
//include( plugin_dir_path ( __FILE__ ) . 'includes/example6js-menus.php');
