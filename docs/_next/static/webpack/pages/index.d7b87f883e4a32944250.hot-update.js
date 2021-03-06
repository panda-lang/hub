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

  var view = token ? /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(ProfileMenu, {}, void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 88,
    columnNumber: 24
  }, _this) : /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(Login, {}, void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 88,
    columnNumber: 41
  }, _this);
  console.log('profile');
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Flex"], _objectSpread(_objectSpread({
    alignItems: "center",
    display: {
      sm: 'flex',
      base: 'none'
    }
  }, props), {}, {
    children: view
  }), void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 91,
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
        lineNumber: 101,
        columnNumber: 9
      }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Text"], {
        marginTop: "4px",
        marginLeft: "7px",
        children: /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(react_icons_fa__WEBPACK_IMPORTED_MODULE_4__["FaGithub"], {
          fontSize: "1.15rem"
        }, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 103,
          columnNumber: 11
        }, _this)
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 102,
        columnNumber: 9
      }, _this)]
    }, void 0, true, {
      fileName: _jsxFileName,
      lineNumber: 100,
      columnNumber: 7
    }, _this)
  }), void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 99,
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
          lineNumber: 117,
          columnNumber: 44
        }, _this),
        children: profile.username
      }, void 0, false, {
        fileName: _jsxFileName,
        lineNumber: 117,
        columnNumber: 9
      }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuList"], {
        children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuDivider"], {}, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 121,
          columnNumber: 11
        }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["Box"], {
          paddingX: "12px",
          children: ["Dark mode", /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(components_layout_ThemeSwitch__WEBPACK_IMPORTED_MODULE_6__["default"], {
            marginX: "7px"
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 124,
            columnNumber: 13
          }, _this)]
        }, void 0, true, {
          fileName: _jsxFileName,
          lineNumber: 122,
          columnNumber: 11
        }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuDivider"], {}, void 0, false, {
          fileName: _jsxFileName,
          lineNumber: 126,
          columnNumber: 11
        }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuGroup"], {
          children: [/*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuItem"], {
            children: "My profile"
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 128,
            columnNumber: 13
          }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuItem"], {
            children: "Settings "
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 129,
            columnNumber: 13
          }, _this), /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_1__["jsxDEV"])(_chakra_ui_react__WEBPACK_IMPORTED_MODULE_2__["MenuItem"], {
            onClick: handleLogout,
            children: "Logout"
          }, void 0, false, {
            fileName: _jsxFileName,
            lineNumber: 130,
            columnNumber: 13
          }, _this)]
        }, void 0, true, {
          fileName: _jsxFileName,
          lineNumber: 127,
          columnNumber: 11
        }, _this)]
      }, void 0, true, {
        fileName: _jsxFileName,
        lineNumber: 120,
        columnNumber: 9
      }, _this)]
    }, void 0, true, {
      fileName: _jsxFileName,
      lineNumber: 116,
      columnNumber: 7
    }, _this)
  }, void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 115,
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
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9fTl9FLy4vc3JjL2NvbXBvbmVudHMvbGF5b3V0L0hlYWRlci5qcyJdLCJuYW1lcyI6WyJIZWFkZXIiLCJwcm9wcyIsImJnQ29sb3IiLCJ1c2VDb2xvck1vZGVWYWx1ZSIsImNvbG9yIiwiY29uc29sZSIsImxvZyIsInNtIiwiYmFzZSIsIm91dGxpbmUiLCJOYXZpZ2F0aW9uIiwiTmF2aWdhdGlvbkl0ZW0iLCJocmVmIiwibGFiZWwiLCJQcm9maWxlIiwidXNlQXV0aCIsInRva2VuIiwidmlldyIsIkxvZ2luIiwiUHJvZmlsZU1lbnUiLCJ1c2VyIiwiaGFuZGxlTG9nb3V0IiwicHJvZmlsZSIsIkJ1dHRvbiIsInVzZXJuYW1lIl0sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7QUFBQTtBQWVBO0FBQ0E7QUFDQTtBQUVBO0FBQ0E7O0FBRUEsSUFBTUEsTUFBTSxHQUFHLFNBQVRBLE1BQVMsQ0FBQ0MsS0FBRCxFQUFXO0FBQUE7O0FBQ3hCLE1BQU1DLE9BQU8sR0FBR0MsMEVBQWlCLENBQUMsU0FBRCxFQUFZLFVBQVosQ0FBakM7QUFDQSxNQUFNQyxLQUFLLEdBQUdELDBFQUFpQixDQUFDLE9BQUQsRUFBVSxPQUFWLENBQS9CO0FBQ0FFLFNBQU8sQ0FBQ0MsR0FBUixDQUFZLFFBQVo7QUFFQSxzQkFDRSxxRUFBQyxxRUFBRDtBQUNFLFVBQU0sRUFBQyxHQURUO0FBRUUsVUFBTSxFQUFFO0FBQUVDLFFBQUUsRUFBRSxRQUFOO0FBQWdCQyxVQUFJLEVBQUU7QUFBdEIsS0FGVjtBQUdFLE1BQUUsRUFBRU4sT0FITjtBQUlFLFNBQUssRUFBRUUsS0FKVDtBQUtFLFVBQU0sRUFBQyxJQUxUO0FBTUUsWUFBUSxFQUFDO0FBTlgsS0FPTUgsS0FQTjtBQUFBLDJCQVNFLHFFQUFDLG1FQUFEO0FBQ0UsbUJBQWEsRUFBRTtBQUFFTSxVQUFFLEVBQUUsS0FBTjtBQUFhQyxZQUFJLEVBQUU7QUFBbkIsT0FEakI7QUFFRSxv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QTtBQUFBO0FBQUEsaUJBQW5DO0FBQUEsa0JBQ0dELE9BQU8sQ0FBQ0U7QUFEWDtBQUFBO0FBQUE7QUFBQTtBQUFBLGVBREYsZUFJRSxxRUFBQyx5REFBRDtBQUFBLGdDQUNFLHFFQUFDLDREQUFEO0FBQUE7QUFBQTtBQUFBO0FBQUEsaUJBREYsZUFFRSxxRUFBQyxvREFBRDtBQUFLLGtCQUFRLEVBQUMsTUFBZDtBQUFBLCtDQUVFLHFFQUFDLHFFQUFEO0FBQWEsbUJBQU8sRUFBQztBQUFyQjtBQUFBO0FBQUE7QUFBQTtBQUFBLG1CQUZGO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQSxpQkFGRixlQU1FLHFFQUFDLDREQUFEO0FBQUE7QUFBQTtBQUFBO0FBQUEsaUJBTkYsZUFPRSxxRUFBQywwREFBRDtBQUFBLGtDQUNFLHFFQUFDLHlEQUFEO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBLG1CQURGLGVBRUUscUVBQUMseURBQUQ7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsbUJBRkYsZUFHRSxxRUFBQyx5REFBRDtBQUFVLG1CQUFPLEVBQUVILFlBQW5CO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBLG1CQUhGO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQSxpQkFQRjtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUEsZUFKRjtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFERjtBQUFBO0FBQUE7QUFBQTtBQUFBLFdBREY7QUFzQkQsQ0ExQkQ7O0lBQU1GLFc7VUFDMkJKLCtEOzs7TUFEM0JJLFc7QUE0QlNuQixxRUFBZiIsImZpbGUiOiJzdGF0aWMvd2VicGFjay9wYWdlcy9pbmRleC5kN2I4N2Y4ODNlNGEzMjk0NDI1MC5ob3QtdXBkYXRlLmpzIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHtcbiAgRmxleCxcbiAgQm94LFxuICBIZWFkaW5nLFxuICBMaW5rLFxuICBCdXR0b24sXG4gIFRleHQsXG4gIE1lbnUsXG4gIE1lbnVCdXR0b24sXG4gIE1lbnVJdGVtLFxuICBNZW51R3JvdXAsXG4gIE1lbnVMaXN0LFxuICBNZW51RGl2aWRlcixcbiAgdXNlQ29sb3JNb2RlVmFsdWVcbn0gZnJvbSAnQGNoYWtyYS11aS9yZWFjdCdcbmltcG9ydCB7IENvbnRhaW5lciwgQ29udGVudCB9IGZyb20gJ2NvbXBvbmVudHMvbGF5b3V0L0NvbnRhaW5lcidcbmltcG9ydCB7IEZhR2l0aHViIH0gZnJvbSAncmVhY3QtaWNvbnMvZmEnXG5pbXBvcnQgeyBNZEFycm93RHJvcERvd24gfSBmcm9tICdyZWFjdC1pY29ucy9tZCdcblxuaW1wb3J0IFRoZW1lU3dpdGNoIGZyb20gJ2NvbXBvbmVudHMvbGF5b3V0L1RoZW1lU3dpdGNoJ1xuaW1wb3J0IHsgdXNlQXV0aCB9IGZyb20gJ2NvbXBvbmVudHMvQXV0aFByb3ZpZGVyJ1xuXG5jb25zdCBIZWFkZXIgPSAocHJvcHMpID0+IHtcbiAgY29uc3QgYmdDb2xvciA9IHVzZUNvbG9yTW9kZVZhbHVlKCdncmF5LjUwJywgJ2dyYXkuOTAwJylcbiAgY29uc3QgY29sb3IgPSB1c2VDb2xvck1vZGVWYWx1ZSgnYmxhY2snLCAnd2hpdGUnKVxuICBjb25zb2xlLmxvZygnaGVhZGVyJylcblxuICByZXR1cm4gKFxuICAgIDxDb250YWluZXJcbiAgICAgIHpJbmRleD1cIjFcIlxuICAgICAgaGVpZ2h0PXt7IHNtOiAnNC41cmVtJywgYmFzZTogJ2F1dG8nIH19XG4gICAgICBiZz17YmdDb2xvcn1cbiAgICAgIGNvbG9yPXtjb2xvcn1cbiAgICAgIHNoYWRvdz1cInNtXCJcbiAgICAgIHBhZGRpbmdYPVwiMzdweFwiXG4gICAgICB7Li4ucHJvcHN9XG4gICAgPlxuICAgICAgPENvbnRlbnRcbiAgICAgICAgZmxleERpcmVjdGlvbj17eyBzbTogJ3JvdycsIGJhc2U6ICdjb2x1bW4nIH19XG4gICAgICAgIGp1c3RpZnlDb250ZW50PVwic3BhY2UtYmV0d2VlblwiXG4gICAgICAgIGFsaWduSXRlbXM9XCJjZW50ZXJcIlxuICAgICAgPlxuICAgICAgICA8Qm94XG4gICAgICAgICAgd2lkdGg9e3sgc206ICcxMDBweCcsIGJhc2U6ICdhdXRvJyB9fVxuICAgICAgICAgIHBhZGRpbmdZPXt7IHNtOiAnMHB4JywgYmFzZTogJzdweCcgfX1cbiAgICAgICAgPlxuICAgICAgICAgIDxMaW5rIGhyZWY9XCIvXCIgX2ZvY3VzPXt7IG91dGxpbmU6IDAgfX0+XG4gICAgICAgICAgICA8SGVhZGluZyBmb250U2l6ZT1cIjEuNXJlbVwiIHBhZGRpbmdSaWdodD1cIjBweFwiPlxuICAgICAgICAgICAgICBIdWJcbiAgICAgICAgICAgIDwvSGVhZGluZz5cbiAgICAgICAgICA8L0xpbms+XG4gICAgICAgIDwvQm94PlxuICAgICAgICA8TmF2aWdhdGlvbiBwYWRkaW5nWT17eyBzbTogJzBweCcsIGJhc2U6ICc3cHgnIH19IC8+XG4gICAgICAgIDxQcm9maWxlIHBhZGRpbmdZPXt7IHNtOiAnMHB4JywgYmFzZTogJzdweCcgfX0gLz5cbiAgICAgIDwvQ29udGVudD5cbiAgICA8L0NvbnRhaW5lcj5cbiAgKVxufVxuXG5jb25zdCBOYXZpZ2F0aW9uID0gKHByb3BzKSA9PiB7XG4gIHJldHVybiAoXG4gICAgPEZsZXggey4uLnByb3BzfT5cbiAgICAgIDxOYXZpZ2F0aW9uSXRlbSBsYWJlbD1cIkFib3V0XCIgaHJlZj1cIi9hYm91dFwiIC8+XG4gICAgICA8TmF2aWdhdGlvbkl0ZW0gbGFiZWw9XCJEb2NzXCIgaHJlZj1cIi9kb2NzXCIgLz5cbiAgICAgIDxOYXZpZ2F0aW9uSXRlbSBsYWJlbD1cIkV4cGxvcmVcIiBocmVmPVwiL2V4cGxvcmVcIiAvPlxuICAgICAgPE5hdmlnYXRpb25JdGVtIGxhYmVsPVwiU3VwcG9ydFwiIGhyZWY9XCJodHRwczovL3BhbmRhLWxhbmcub3JnL3N1cHBvcnQvXCIgLz5cbiAgICA8L0ZsZXg+XG4gIClcbn1cblxuY29uc3QgTmF2aWdhdGlvbkl0ZW0gPSAocHJvcHMpID0+IHtcbiAgcmV0dXJuIChcbiAgICA8TGlua1xuICAgICAgaHJlZj17cHJvcHMuaHJlZn1cbiAgICAgIGZvbnRXZWlnaHQ9XCJib2xkXCJcbiAgICAgIHBhZGRpbmdYPVwiMTNweFwiXG4gICAgICBfZm9jdXM9e3sgb3V0bGluZTogMCB9fVxuICAgICAgey4uLnByb3BzfVxuICAgID5cbiAgICAgIHtwcm9wcy5sYWJlbH1cbiAgICA8L0xpbms+XG4gIClcbn1cblxuY29uc3QgUHJvZmlsZSA9IChwcm9wcykgPT4ge1xuICBjb25zdCB7IHRva2VuIH0gPSB1c2VBdXRoKClcblxuICBjb25zdCB2aWV3ID0gdG9rZW4gPyA8UHJvZmlsZU1lbnUvPiA6IDxMb2dpbiAvPlxuICBjb25zb2xlLmxvZygncHJvZmlsZScpXG4gIHJldHVybiAoXG4gICAgPEZsZXggYWxpZ25JdGVtcz1cImNlbnRlclwiIGRpc3BsYXk9e3sgc206ICdmbGV4JywgYmFzZTogJ25vbmUnIH19IHsuLi5wcm9wc30+XG4gICAgICB7dmlld31cbiAgICA8L0ZsZXg+XG4gIClcbn1cblxuY29uc3QgTG9naW4gPSAocHJvcHMpID0+IHtcbiAgcmV0dXJuIChcbiAgICA8TGluayBocmVmPVwiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2F1dGhvcml6ZS9naXRodWJcIiB7Li4ucHJvcHN9PlxuICAgICAgPEZsZXggd2lkdGg9XCIxMDBweFwiPlxuICAgICAgICA8VGV4dD5TaWduIEluPC9UZXh0PlxuICAgICAgICA8VGV4dCBtYXJnaW5Ub3A9XCI0cHhcIiBtYXJnaW5MZWZ0PVwiN3B4XCI+XG4gICAgICAgICAgPEZhR2l0aHViIGZvbnRTaXplPVwiMS4xNXJlbVwiIC8+XG4gICAgICAgIDwvVGV4dD5cbiAgICAgIDwvRmxleD5cbiAgICA8L0xpbms+XG4gIClcbn1cblxuY29uc3QgUHJvZmlsZU1lbnUgPSAocHJvcHMpID0+IHtcbiAgY29uc3QgeyB1c2VyLCBoYW5kbGVMb2dvdXQgfSA9IHVzZUF1dGgoKVxuICBjb25zdCBwcm9maWxlID0gdXNlciB8fCB7fVxuXG4gIHJldHVybiAoXG4gICAgPEZsZXg+XG4gICAgICA8TWVudT5cbiAgICAgICAgPE1lbnVCdXR0b24gYXM9e0J1dHRvbn0gcmlnaHRJY29uPXs8TWRBcnJvd0Ryb3BEb3duIC8+fT5cbiAgICAgICAgICB7cHJvZmlsZS51c2VybmFtZX1cbiAgICAgICAgPC9NZW51QnV0dG9uPlxuICAgICAgICA8TWVudUxpc3Q+XG4gICAgICAgICAgPE1lbnVEaXZpZGVyIC8+XG4gICAgICAgICAgPEJveCBwYWRkaW5nWD1cIjEycHhcIj5cbiAgICAgICAgICAgIERhcmsgbW9kZVxuICAgICAgICAgICAgPFRoZW1lU3dpdGNoIG1hcmdpblg9XCI3cHhcIiAvPlxuICAgICAgICAgIDwvQm94PlxuICAgICAgICAgIDxNZW51RGl2aWRlciAvPlxuICAgICAgICAgIDxNZW51R3JvdXA+XG4gICAgICAgICAgICA8TWVudUl0ZW0+TXkgcHJvZmlsZTwvTWVudUl0ZW0+XG4gICAgICAgICAgICA8TWVudUl0ZW0+U2V0dGluZ3MgPC9NZW51SXRlbT5cbiAgICAgICAgICAgIDxNZW51SXRlbSBvbkNsaWNrPXtoYW5kbGVMb2dvdXR9PkxvZ291dDwvTWVudUl0ZW0+XG4gICAgICAgICAgPC9NZW51R3JvdXA+XG4gICAgICAgIDwvTWVudUxpc3Q+XG4gICAgICA8L01lbnU+XG4gICAgPC9GbGV4PlxuICApXG59XG5cbmV4cG9ydCBkZWZhdWx0IEhlYWRlclxuIl0sInNvdXJjZVJvb3QiOiIifQ==