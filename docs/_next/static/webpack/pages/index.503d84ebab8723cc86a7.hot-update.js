webpackHotUpdate_N_E("pages/index",{

/***/ "./src/components/layout/Header.js":
/*!*****************************************!*\
  !*** ./src/components/layout/Header.js ***!
  \*****************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* WEBPACK VAR INJECTION */(function(module) {/* harmony import */ var J_Java_Spring_hub_hub_frontend_node_modules_babel_runtime_helpers_esm_defineProperty__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/defineProperty */ "./node_modules/@babel/runtime/helpers/esm/defineProperty.js");
/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! react/jsx-dev-runtime */ "./node_modules/react/jsx-dev-runtime.js");
/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var _chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @chakra-ui/react */ "./node_modules/@chakra-ui/react/dist/esm/index.js");
/* harmony import */ var components_layout_Container__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! components/layout/Container */ "./src/components/layout/Container.js");
/* harmony import */ var react_icons_fa__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! react-icons/fa */ "./node_modules/react-icons/fa/index.esm.js");
/* harmony import */ var react_icons_md__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! react-icons/md */ "./node_modules/react-icons/md/index.esm.js");
/* harmony import */ var components_layout_ThemeSwitch__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! components/layout/ThemeSwitch */ "./src/components/layout/ThemeSwitch.js");
/* harmony import */ var components_AuthProvider__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! components/AuthProvider */ "./src/components/AuthProvider.js");



var _jsxFileName = "J:\\Java\\Spring\\hub\\hub-frontend\\src\\components\\layout\\Header.js",
    _this = undefined,
    _s = $RefreshSig$(),
    _s2 = $RefreshSig$(),
    _s3 = $RefreshSig$();

function ownKeys(object, enumerableOnly) { var keys = Object.keys(object); if (Object.getOwnPropertySymbols) { var symbols = Object.getOwnPropertySymbols(object); if (enumerableOnly) symbols = symbols.filter(function (sym) { return Object.getOwnPropertyDescriptor(object, sym).enumerable; }); keys.push.apply(keys, symbols); } return keys; }

function _objectSpread(target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i] != null ? arguments[i] : {}; if (i % 2) { ownKeys(Object(source), true).forEach(function (key) { Object(J_Java_Spring_hub_hub_frontend_node_modules_babel_runtime_helpers_esm_defineProperty__WEBPACK_IMPORTED_MODULE_0__["default"])(target, key, source[key]); }); } else if (Object.getOwnPropertyDescriptors) { Object.defineProperties(target, Object.getOwnPropertyDescriptors(source)); } else { ownKeys(Object(source)).forEach(function (key) { Object.defineProperty(target, key, Object.getOwnPropertyDescriptor(source, key)); }); } } return target; }








var Header = function Header(props) {
  _s();

  var bgColor = Object(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["useColorModeValue"])('gray.50', 'gray.900');
  var color = Object(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["useColorModeValue"])('black', 'white');
  console.log('header');
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(components_layout_Container__WEBPACK_IMPORTED_MODULE_3__["Container"], _objectSpread(_objectSpread({
    zIndex: "1",
    height: {
      sm: '4.5rem',
      base: 'auto'
    },
    bg: bgColor,
    color: color,
    shadow: "sm",
    paddingX: "37px"
  }, props), {}, {
    children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(components_layout_Container__WEBPACK_IMPORTED_MODULE_3__["Content"], {
      flexDirection: {
        sm: 'row',
        base: 'column'
      },
      justifyContent: "space-between",
      alignItems: "center",
      children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Box"], {
        width: {
          sm: '100px',
          base: 'auto'
        },
        paddingY: {
          sm: '0px',
          base: '7px'
        },
        children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Link"], {
          href: "/",
          _focus: {
            outline: 0
          },
          children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Heading"], {
            fontSize: "1.5rem",
            paddingRight: "0px",
            children: "Hub"
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 48,
            columnNumber: 13
          }, _this)
        }, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 47,
          columnNumber: 11
        }, _this)
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 43,
        columnNumber: 9
      }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(Navigation, {
        paddingY: {
          sm: '0px',
          base: '7px'
        }
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 53,
        columnNumber: 9
      }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(Profile, {
        paddingY: {
          sm: '0px',
          base: '7px'
        }
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 54,
        columnNumber: 9
      }, _this)]
    }, void 0, true, {
      fileName: _jsxFileName,
      lineNumber: 38,
      columnNumber: 7
    }, _this)
  }), void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 29,
    columnNumber: 5
  }, _this);
};

_s(Header, "GxINmYQjSw+rm7TrtZAlo2dz7DQ=", false, function () {
  return [_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["useColorModeValue"], _chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["useColorModeValue"]];
});

_c = Header;

var Navigation = function Navigation(props) {
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Flex"], _objectSpread(_objectSpread({}, props), {}, {
    children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(NavigationItem, {
      label: "About",
      href: "/about"
    }, void 0, false, {
      fileName: _jsxFileName,
      lineNumber: 63,
      columnNumber: 7
    }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(NavigationItem, {
      label: "Docs",
      href: "/docs"
    }, void 0, false, {
      fileName: _jsxFileName,
      lineNumber: 64,
      columnNumber: 7
    }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(NavigationItem, {
      label: "Explore",
      href: "/explore"
    }, void 0, false, {
      fileName: _jsxFileName,
      lineNumber: 65,
      columnNumber: 7
    }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(NavigationItem, {
      label: "Support",
      href: "https://panda-lang.org/support/"
    }, void 0, false, {
      fileName: _jsxFileName,
      lineNumber: 66,
      columnNumber: 7
    }, _this)]
  }), void 0, true, {
    fileName: _jsxFileName,
    lineNumber: 62,
    columnNumber: 5
  }, _this);
};

_c2 = Navigation;

var NavigationItem = function NavigationItem(props) {
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Link"], _objectSpread(_objectSpread({
    href: props.href,
    fontWeight: "bold",
    paddingX: "13px",
    _focus: {
      outline: 0
    }
  }, props), {}, {
    children: props.label
  }), void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 73,
    columnNumber: 5
  }, _this);
};

_c3 = NavigationItem;

var Profile = function Profile(props) {
  _s2();

  var _useAuth = Object(components_AuthProvider__WEBPACK_IMPORTED_MODULE_7__["useAuth"])(),
      token = _useAuth.token;

  console.log('profile');
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Flex"], _objectSpread(_objectSpread({
    alignItems: "center",
    display: {
      sm: 'flex',
      base: 'none'
    }
  }, props), {}, {
    children: token ? /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(ProfileMenu, {}, void 0, false, {
      fileName: _jsxFileName,
      lineNumber: 90,
      columnNumber: 17
    }, _this) : /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(Login, {}, void 0, false, {
      fileName: _jsxFileName,
      lineNumber: 90,
      columnNumber: 34
    }, _this)
  }), void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 89,
    columnNumber: 5
  }, _this);
};

_s2(Profile, "ZpOvj47KCDv4EW5BIUHQHDAsr3M=", false, function () {
  return [components_AuthProvider__WEBPACK_IMPORTED_MODULE_7__["useAuth"]];
});

_c4 = Profile;

var Login = function Login(props) {
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Link"], _objectSpread(_objectSpread({
    href: "http://localhost:8080/authorize/github"
  }, props), {}, {
    children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Flex"], {
      width: "100px",
      children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Text"], {
        children: "Sign In"
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 99,
        columnNumber: 9
      }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Text"], {
        marginTop: "4px",
        marginLeft: "7px",
        children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(react_icons_fa__WEBPACK_IMPORTED_MODULE_4__["FaGithub"], {
          fontSize: "1.15rem"
        }, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 101,
          columnNumber: 11
        }, _this)
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 100,
        columnNumber: 9
      }, _this)]
    }, void 0, true, {
      fileName: _jsxFileName,
      lineNumber: 98,
      columnNumber: 7
    }, _this)
  }), void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 97,
    columnNumber: 5
  }, _this);
};

_c5 = Login;

var ProfileMenu = function ProfileMenu(props) {
  _s3();

  var _useAuth2 = Object(components_AuthProvider__WEBPACK_IMPORTED_MODULE_7__["useAuth"])(),
      user = _useAuth2.user,
      handleLogout = _useAuth2.handleLogout;

  var profile = user || {};
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Flex"], {
    children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Menu"], {
      children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuButton"], {
        as: _chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Button"],
        rightIcon: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(react_icons_md__WEBPACK_IMPORTED_MODULE_5__["MdArrowDropDown"], {}, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 115,
          columnNumber: 44
        }, _this),
        children: profile.username
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 115,
        columnNumber: 9
      }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuList"], {
        children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuDivider"], {}, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 119,
          columnNumber: 11
        }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Box"], {
          paddingX: "12px",
          children: ["Dark mode", /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(components_layout_ThemeSwitch__WEBPACK_IMPORTED_MODULE_6__["default"], {
            marginX: "7px"
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 122,
            columnNumber: 13
          }, _this)]
        }, void 0, true, {
          fileName: _jsxFileName,
          lineNumber: 120,
          columnNumber: 11
        }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuDivider"], {}, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 124,
          columnNumber: 11
        }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuGroup"], {
          children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuItem"], {
            children: "My profile"
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 126,
            columnNumber: 13
          }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuItem"], {
            children: "Settings "
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 127,
            columnNumber: 13
          }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuItem"], {
            onClick: handleLogout,
            children: "Logout"
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 128,
            columnNumber: 13
          }, _this)]
        }, void 0, true, {
          fileName: _jsxFileName,
          lineNumber: 125,
          columnNumber: 11
        }, _this)]
      }, void 0, true, {
        fileName: _jsxFileName,
        lineNumber: 118,
        columnNumber: 9
      }, _this)]
    }, void 0, true, {
      fileName: _jsxFileName,
      lineNumber: 114,
      columnNumber: 7
    }, _this)
  }, void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 113,
    columnNumber: 5
  }, _this);
};

_s3(ProfileMenu, "mSW+RoajZBiJZe2sByCSxGQKiOI=", false, function () {
  return [components_AuthProvider__WEBPACK_IMPORTED_MODULE_7__["useAuth"]];
});

_c6 = ProfileMenu;
/* harmony default export */ __webpack_exports__["default"] = (Header);

var _c, _c2, _c3, _c4, _c5, _c6;

$RefreshReg$(_c, "Header");
$RefreshReg$(_c2, "Navigation");
$RefreshReg$(_c3, "NavigationItem");
$RefreshReg$(_c4, "Profile");
$RefreshReg$(_c5, "Login");
$RefreshReg$(_c6, "ProfileMenu");

;
    var _a, _b;
    // Legacy CSS implementations will `eval` browser code in a Node.js context
    // to extract CSS. For backwards compatibility, we need to check we're in a
    // browser context before continuing.
    if (typeof self !== 'undefined' &&
        // AMP / No-JS mode does not inject these helpers:
        '$RefreshHelpers$' in self) {
        var currentExports = module.__proto__.exports;
        var prevExports = (_b = (_a = module.hot.data) === null || _a === void 0 ? void 0 : _a.prevExports) !== null && _b !== void 0 ? _b : null;
        // This cannot happen in MainTemplate because the exports mismatch between
        // templating and execution.
        self.$RefreshHelpers$.registerExportsForReactRefresh(currentExports, module.i);
        // A module can be accepted automatically based on its exports, e.g. when
        // it is a Refresh Boundary.
        if (self.$RefreshHelpers$.isReactRefreshBoundary(currentExports)) {
            // Save the previous exports on update so we can compare the boundary
            // signatures.
            module.hot.dispose(function (data) {
                data.prevExports = currentExports;
            });
            // Unconditionally accept an update to this module, we'll check if it's
            // still a Refresh Boundary later.
            module.hot.accept();
            // This field is set when the previous version of this module was a
            // Refresh Boundary, letting us know we need to check for invalidation or
            // enqueue an update.
            if (prevExports !== null) {
                // A boundary can become ineligible if its exports are incompatible
                // with the previous exports.
                //
                // For example, if you add/remove/change exports, we'll want to
                // re-execute the importing modules, and force those components to
                // re-render. Similarly, if you convert a class component to a
                // function, we want to invalidate the boundary.
                if (self.$RefreshHelpers$.shouldInvalidateReactRefreshBoundary(prevExports, currentExports)) {
                    module.hot.invalidate();
                }
                else {
                    self.$RefreshHelpers$.scheduleUpdate();
                }
            }
        }
        else {
            // Since we just executed the code for the module, it's possible that the
            // new exports made it ineligible for being a boundary.
            // We only care about the case when we were _previously_ a boundary,
            // because we already accepted this update (accidental side effect).
            var isNoLongerABoundary = prevExports !== null;
            if (isNoLongerABoundary) {
                module.hot.invalidate();
            }
        }
    }

/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./../../../node_modules/next/dist/compiled/webpack/harmony-module.js */ "./node_modules/next/dist/compiled/webpack/harmony-module.js")(module)))

/***/ })

})
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9fTl9FLy4vc3JjL2NvbXBvbmVudHMvbGF5b3V0L0hlYWRlci5qcyJdLCJuYW1lcyI6WyJIZWFkZXIiLCJwcm9wcyIsImJnQ29sb3IiLCJ1c2VDb2xvck1vZGVWYWx1ZSIsImNvbG9yIiwiY29uc29sZSIsImxvZyIsInNtIiwiYmFzZSIsIm91dGxpbmUiLCJOYXZpZ2F0aW9uIiwiTmF2aWdhdGlvbkl0ZW0iLCJocmVmIiwibGFiZWwiLCJQcm9maWxlIiwidXNlQXV0aCIsInRva2VuIiwiTG9naW4iLCJQcm9maWxlTWVudSIsInVzZXIiLCJoYW5kbGVMb2dvdXQiLCJwcm9maWxlIiwiQnV0dG9uIiwidXNlcm5hbWUiXSwibWFwcGluZ3MiOiI7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7OztBQUFBO0FBZUE7QUFDQTtBQUNBO0FBRUE7QUFDQTs7QUFFQSxJQUFNQSxNQUFNLEdBQUcsU0FBVEEsTUFBUyxDQUFDQyxLQUFELEVBQVc7QUFBQTs7QUFDeEIsTUFBTUMsT0FBTyxHQUFHQywwRUFBaUIsQ0FBQyxTQUFELEVBQVksVUFBWixDQUFqQztBQUNBLE1BQU1DLEtBQUssR0FBR0QsMEVBQWlCLENBQUMsT0FBRCxFQUFVLE9BQVYsQ0FBL0I7QUFDQUUsU0FBTyxDQUFDQyxHQUFSLENBQVksUUFBWjtBQUVBLHNCQUNFLHFFQUFDLHFFQUFEO0FBQ0UsVUFBTSxFQUFDLEdBRFQ7QUFFRSxVQUFNLEVBQUU7QUFBRUMsUUFBRSxFQUFFLFFBQU47QUFBZ0JDLFVBQUksRUFBRTtBQUF0QixLQUZWO0FBR0UsTUFBRSxFQUFFTixPQUhOO0FBSUUsU0FBSyxFQUFFRSxLQUpUO0FBS0UsVUFBTSxFQUFDLElBTFQ7QUFNRSxZQUFRLEVBQUM7QUFOWCxLQU9NSCxLQVBOO0FBQUEsMkJBU0UscUVBQUMsbUVBQUQ7QUFDRSxtQkFBYSxFQUFFO0FBQUVNLFVBQUUsRUFBRSxLQUFOO0FBQWFDLFlBQUksRUFBRTtBQUFuQixPQURqQjtBQUVFLG9CQUFjLEVB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LENBQUNFO0FBRFg7QUFBQTtBQUFBO0FBQUE7QUFBQSxlQURGLGVBSUUscUVBQUMseURBQUQ7QUFBQSxnQ0FDRSxxRUFBQyw0REFBRDtBQUFBO0FBQUE7QUFBQTtBQUFBLGlCQURGLGVBRUUscUVBQUMsb0RBQUQ7QUFBSyxrQkFBUSxFQUFDLE1BQWQ7QUFBQSwrQ0FFRSxxRUFBQyxxRUFBRDtBQUFhLG1CQUFPLEVBQUM7QUFBckI7QUFBQTtBQUFBO0FBQUE7QUFBQSxtQkFGRjtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsaUJBRkYsZUFNRSxxRUFBQyw0REFBRDtBQUFBO0FBQUE7QUFBQTtBQUFBLGlCQU5GLGVBT0UscUVBQUMsMERBQUQ7QUFBQSxrQ0FDRSxxRUFBQyx5REFBRDtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQSxtQkFERixlQUVFLHFFQUFDLHlEQUFEO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBLG1CQUZGLGVBR0UscUVBQUMseURBQUQ7QUFBVSxtQkFBTyxFQUFFSCxZQUFuQjtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQSxtQkFIRjtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsaUJBUEY7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBLGVBSkY7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBREY7QUFBQTtBQUFBO0FBQUE7QUFBQSxXQURGO0FBc0JELENBMUJEOztJQUFNRixXO1VBQzJCSCwrRDs7O01BRDNCRyxXO0FBNEJTbEIscUVBQWYiLCJmaWxlIjoic3RhdGljL3dlYnBhY2svcGFnZXMvaW5kZXguNTAzZDg0ZWJhYjg3MjNjYzg2YTcuaG90LXVwZGF0ZS5qcyIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7XG4gIEZsZXgsXG4gIEJveCxcbiAgSGVhZGluZyxcbiAgTGluayxcbiAgQnV0dG9uLFxuICBUZXh0LFxuICBNZW51LFxuICBNZW51QnV0dG9uLFxuICBNZW51SXRlbSxcbiAgTWVudUdyb3VwLFxuICBNZW51TGlzdCxcbiAgTWVudURpdmlkZXIsXG4gIHVzZUNvbG9yTW9kZVZhbHVlLFxufSBmcm9tICdAY2hha3JhLXVpL3JlYWN0J1xuaW1wb3J0IHsgQ29udGFpbmVyLCBDb250ZW50IH0gZnJvbSAnY29tcG9uZW50cy9sYXlvdXQvQ29udGFpbmVyJ1xuaW1wb3J0IHsgRmFHaXRodWIgfSBmcm9tICdyZWFjdC1pY29ucy9mYSdcbmltcG9ydCB7IE1kQXJyb3dEcm9wRG93biB9IGZyb20gJ3JlYWN0LWljb25zL21kJ1xuXG5pbXBvcnQgVGhlbWVTd2l0Y2ggZnJvbSAnY29tcG9uZW50cy9sYXlvdXQvVGhlbWVTd2l0Y2gnXG5pbXBvcnQgeyB1c2VBdXRoIH0gZnJvbSAnY29tcG9uZW50cy9BdXRoUHJvdmlkZXInXG5cbmNvbnN0IEhlYWRlciA9IChwcm9wcykgPT4ge1xuICBjb25zdCBiZ0NvbG9yID0gdXNlQ29sb3JNb2RlVmFsdWUoJ2dyYXkuNTAnLCAnZ3JheS45MDAnKVxuICBjb25zdCBjb2xvciA9IHVzZUNvbG9yTW9kZVZhbHVlKCdibGFjaycsICd3aGl0ZScpXG4gIGNvbnNvbGUubG9nKCdoZWFkZXInKVxuXG4gIHJldHVybiAoXG4gICAgPENvbnRhaW5lclxuICAgICAgekluZGV4PVwiMVwiXG4gICAgICBoZWlnaHQ9e3sgc206ICc0LjVyZW0nLCBiYXNlOiAnYXV0bycgfX1cbiAgICAgIGJnPXtiZ0NvbG9yfVxuICAgICAgY29sb3I9e2NvbG9yfVxuICAgICAgc2hhZG93PVwic21cIlxuICAgICAgcGFkZGluZ1g9XCIzN3B4XCJcbiAgICAgIHsuLi5wcm9wc31cbiAgICA+XG4gICAgICA8Q29udGVudFxuICAgICAgICBmbGV4RGlyZWN0aW9uPXt7IHNtOiAncm93JywgYmFzZTogJ2NvbHVtbicgfX1cbiAgICAgICAganVzdGlmeUNvbnRlbnQ9XCJzcGFjZS1iZXR3ZWVuXCJcbiAgICAgICAgYWxpZ25JdGVtcz1cImNlbnRlclwiXG4gICAgICA+XG4gICAgICAgIDxCb3hcbiAgICAgICAgICB3aWR0aD17eyBzbTogJzEwMHB4JywgYmFzZTogJ2F1dG8nIH19XG4gICAgICAgICAgcGFkZGluZ1k9e3sgc206ICcwcHgnLCBiYXNlOiAnN3B4JyB9fVxuICAgICAgICA+XG4gICAgICAgICAgPExpbmsgaHJlZj1cIi9cIiBfZm9jdXM9e3sgb3V0bGluZTogMCB9fT5cbiAgICAgICAgICAgIDxIZWFkaW5nIGZvbnRTaXplPVwiMS41cmVtXCIgcGFkZGluZ1JpZ2h0PVwiMHB4XCI+XG4gICAgICAgICAgICAgIEh1YlxuICAgICAgICAgICAgPC9IZWFkaW5nPlxuICAgICAgICAgIDwvTGluaz5cbiAgICAgICAgPC9Cb3g+XG4gICAgICAgIDxOYXZpZ2F0aW9uIHBhZGRpbmdZPXt7IHNtOiAnMHB4JywgYmFzZTogJzdweCcgfX0gLz5cbiAgICAgICAgPFByb2ZpbGUgcGFkZGluZ1k9e3sgc206ICcwcHgnLCBiYXNlOiAnN3B4JyB9fSAvPlxuICAgICAgPC9Db250ZW50PlxuICAgIDwvQ29udGFpbmVyPlxuICApXG59XG5cbmNvbnN0IE5hdmlnYXRpb24gPSAocHJvcHMpID0+IHtcbiAgcmV0dXJuIChcbiAgICA8RmxleCB7Li4ucHJvcHN9PlxuICAgICAgPE5hdmlnYXRpb25JdGVtIGxhYmVsPVwiQWJvdXRcIiBocmVmPVwiL2Fib3V0XCIgLz5cbiAgICAgIDxOYXZpZ2F0aW9uSXRlbSBsYWJlbD1cIkRvY3NcIiBocmVmPVwiL2RvY3NcIiAvPlxuICAgICAgPE5hdmlnYXRpb25JdGVtIGxhYmVsPVwiRXhwbG9yZVwiIGhyZWY9XCIvZXhwbG9yZVwiIC8+XG4gICAgICA8TmF2aWdhdGlvbkl0ZW0gbGFiZWw9XCJTdXBwb3J0XCIgaHJlZj1cImh0dHBzOi8vcGFuZGEtbGFuZy5vcmcvc3VwcG9ydC9cIiAvPlxuICAgIDwvRmxleD5cbiAgKVxufVxuXG5jb25zdCBOYXZpZ2F0aW9uSXRlbSA9IChwcm9wcykgPT4ge1xuICByZXR1cm4gKFxuICAgIDxMaW5rXG4gICAgICBocmVmPXtwcm9wcy5ocmVmfVxuICAgICAgZm9udFdlaWdodD1cImJvbGRcIlxuICAgICAgcGFkZGluZ1g9XCIxM3B4XCJcbiAgICAgIF9mb2N1cz17eyBvdXRsaW5lOiAwIH19XG4gICAgICB7Li4ucHJvcHN9XG4gICAgPlxuICAgICAge3Byb3BzLmxhYmVsfVxuICAgIDwvTGluaz5cbiAgKVxufVxuXG5jb25zdCBQcm9maWxlID0gKHByb3BzKSA9PiB7XG4gIGNvbnN0IHsgdG9rZW4gfSA9IHVzZUF1dGgoKVxuICBjb25zb2xlLmxvZygncHJvZmlsZScpXG4gIHJldHVybiAoXG4gICAgPEZsZXggYWxpZ25JdGVtcz1cImNlbnRlclwiIGRpc3BsYXk9e3sgc206ICdmbGV4JywgYmFzZTogJ25vbmUnIH19IHsuLi5wcm9wc30+XG4gICAgICB7IHRva2VuID8gPFByb2ZpbGVNZW51Lz4gOiA8TG9naW4gLz4gfVxuICAgIDwvRmxleD5cbiAgKVxufVxuXG5jb25zdCBMb2dpbiA9IChwcm9wcykgPT4ge1xuICByZXR1cm4gKFxuICAgIDxMaW5rIGhyZWY9XCJodHRwOi8vbG9jYWxob3N0OjgwODAvYXV0aG9yaXplL2dpdGh1YlwiIHsuLi5wcm9wc30+XG4gICAgICA8RmxleCB3aWR0aD1cIjEwMHB4XCI+XG4gICAgICAgIDxUZXh0PlNpZ24gSW48L1RleHQ+XG4gICAgICAgIDxUZXh0IG1hcmdpblRvcD1cIjRweFwiIG1hcmdpbkxlZnQ9XCI3cHhcIj5cbiAgICAgICAgICA8RmFHaXRodWIgZm9udFNpemU9XCIxLjE1cmVtXCIgLz5cbiAgICAgICAgPC9UZXh0PlxuICAgICAgPC9GbGV4PlxuICAgIDwvTGluaz5cbiAgKVxufVxuXG5jb25zdCBQcm9maWxlTWVudSA9IChwcm9wcykgPT4ge1xuICBjb25zdCB7IHVzZXIsIGhhbmRsZUxvZ291dCB9ID0gdXNlQXV0aCgpXG4gIGNvbnN0IHByb2ZpbGUgPSB1c2VyIHx8IHt9XG5cbiAgcmV0dXJuIChcbiAgICA8RmxleD5cbiAgICAgIDxNZW51PlxuICAgICAgICA8TWVudUJ1dHRvbiBhcz17QnV0dG9ufSByaWdodEljb249ezxNZEFycm93RHJvcERvd24gLz59PlxuICAgICAgICAgIHtwcm9maWxlLnVzZXJuYW1lfVxuICAgICAgICA8L01lbnVCdXR0b24+XG4gICAgICAgIDxNZW51TGlzdD5cbiAgICAgICAgICA8TWVudURpdmlkZXIgLz5cbiAgICAgICAgICA8Qm94IHBhZGRpbmdYPVwiMTJweFwiPlxuICAgICAgICAgICAgRGFyayBtb2RlXG4gICAgICAgICAgICA8VGhlbWVTd2l0Y2ggbWFyZ2luWD1cIjdweFwiIC8+XG4gICAgICAgICAgPC9Cb3g+XG4gICAgICAgICAgPE1lbnVEaXZpZGVyIC8+XG4gICAgICAgICAgPE1lbnVHcm91cD5cbiAgICAgICAgICAgIDxNZW51SXRlbT5NeSBwcm9maWxlPC9NZW51SXRlbT5cbiAgICAgICAgICAgIDxNZW51SXRlbT5TZXR0aW5ncyA8L01lbnVJdGVtPlxuICAgICAgICAgICAgPE1lbnVJdGVtIG9uQ2xpY2s9e2hhbmRsZUxvZ291dH0+TG9nb3V0PC9NZW51SXRlbT5cbiAgICAgICAgICA8L01lbnVHcm91cD5cbiAgICAgICAgPC9NZW51TGlzdD5cbiAgICAgIDwvTWVudT5cbiAgICA8L0ZsZXg+XG4gIClcbn1cblxuZXhwb3J0IGRlZmF1bHQgSGVhZGVyXG4iXSwic291cmNlUm9vdCI6IiJ9