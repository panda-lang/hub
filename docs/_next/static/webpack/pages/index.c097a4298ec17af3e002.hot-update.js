webpackHotUpdate_N_E("pages/index",{

/***/ "./src/components/AuthProvider.js":
/*!****************************************!*\
  !*** ./src/components/AuthProvider.js ***!
  \****************************************/
/*! exports provided: AuthProvider, useAuth */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* WEBPACK VAR INJECTION */(function(module) {/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthProvider", function() { return AuthProvider; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "useAuth", function() { return useAuth; });
/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! react/jsx-dev-runtime */ "./node_modules/react/jsx-dev-runtime.js");
/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var J_Java_Spring_hub_hub_frontend_node_modules_babel_runtime_helpers_esm_defineProperty__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/defineProperty */ "./node_modules/@babel/runtime/helpers/esm/defineProperty.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var universal_cookie__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! universal-cookie */ "./node_modules/universal-cookie/es6/index.js");
/* harmony import */ var axios__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! axios */ "./node_modules/axios/index.js");
/* harmony import */ var axios__WEBPACK_IMPORTED_MODULE_4___default = /*#__PURE__*/__webpack_require__.n(axios__WEBPACK_IMPORTED_MODULE_4__);



var _jsxFileName = "J:\\Java\\Spring\\hub\\hub-frontend\\src\\components\\AuthProvider.js",
    _this = undefined,
    _s = $RefreshSig$(),
    _s2 = $RefreshSig$();

function ownKeys(object, enumerableOnly) { var keys = Object.keys(object); if (Object.getOwnPropertySymbols) { var symbols = Object.getOwnPropertySymbols(object); if (enumerableOnly) symbols = symbols.filter(function (sym) { return Object.getOwnPropertyDescriptor(object, sym).enumerable; }); keys.push.apply(keys, symbols); } return keys; }

function _objectSpread(target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i] != null ? arguments[i] : {}; if (i % 2) { ownKeys(Object(source), true).forEach(function (key) { Object(J_Java_Spring_hub_hub_frontend_node_modules_babel_runtime_helpers_esm_defineProperty__WEBPACK_IMPORTED_MODULE_1__["default"])(target, key, source[key]); }); } else if (Object.getOwnPropertyDescriptors) { Object.defineProperties(target, Object.getOwnPropertyDescriptors(source)); } else { ownKeys(Object(source)).forEach(function (key) { Object.defineProperty(target, key, Object.getOwnPropertyDescriptor(source, key)); }); } } return target; }




var AuthContext = /*#__PURE__*/Object(react__WEBPACK_IMPORTED_MODULE_2__["createContext"])();
var cookies = new universal_cookie__WEBPACK_IMPORTED_MODULE_3__["default"]();

var AuthProvider = function AuthProvider(_ref) {
  _s();

  var children = _ref.children;

  var _useState = Object(react__WEBPACK_IMPORTED_MODULE_2__["useState"])(),
      token = _useState[0],
      setToken = _useState[1];

  var _useState2 = Object(react__WEBPACK_IMPORTED_MODULE_2__["useState"])(),
      user = _useState2[0],
      setUser = _useState2[1];

  Object(react__WEBPACK_IMPORTED_MODULE_2__["useEffect"])(function () {
    console.log(token);

    if (token) {
      fetchUser();
    }
  }, []);

  var handleLogin = function handleLogin(jwt) {
    cookies.set('jwt', jwt, {
      path: '/',
      maxAge: 60 * 60 * 24 * 30,
      // 30 days
      sameSite: 'lax'
    });
    setToken(jwt);
  };

  var handleLogout = function handleLogout() {
    cookies.remove('jwt');
    setUser(undefined);
    setToken(undefined);
  };

  var handleRequest = function handleRequest(route, options) {
    return axios__WEBPACK_IMPORTED_MODULE_4___default.a.get("http://localhost:8080".concat(route), _objectSpread({
      headers: {
        Authorization: "Bearer ".concat(token)
      }
    }, options));
  };

  var fetchUser = function fetchUser() {
    handleRequest('/user').then(function (response) {
      setUser(response.data);
    })["catch"](function (error) {
      var _error$data;

      console.log(error);

      if ((error === null || error === void 0 ? void 0 : (_error$data = error.data) === null || _error$data === void 0 ? void 0 : _error$data.status) >= 400) {
        handleLogout();
      }
    });
  };

  var context = {
    token: token,
    user: user,
    handleLogin: handleLogin,
    handleLogout: handleLogout,
    handleRequest: handleRequest
  };
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__["jsxDEV"])(AuthContext.Provider, {
    value: context,
    children: children
  }, void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 64,
    columnNumber: 10
  }, _this);
};

_s(AuthProvider, "NBHE/9HkjsDSVFH75XjEPQ1DHtc=");

_c = AuthProvider;

var useAuth = function useAuth() {
  _s2();

  return Object(react__WEBPACK_IMPORTED_MODULE_2__["useContext"])(AuthContext);
};

_s2(useAuth, "gDsCjeeItUuvgOWf1v4qoK9RF6k=");



var _c;

$RefreshReg$(_c, "AuthProvider");

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

/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./../../node_modules/next/dist/compiled/webpack/harmony-module.js */ "./node_modules/next/dist/compiled/webpack/harmony-module.js")(module)))

/***/ })

})
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9fTl9FLy4vc3JjL2NvbXBvbmVudHMvQXV0aFByb3ZpZGVyLmpzIl0sIm5hbWVzIjpbIkF1dGhDb250ZXh0IiwiY3JlYXRlQ29udGV4dCIsImNvb2tpZXMiLCJDb29raWVzIiwiQXV0aFByb3ZpZGVyIiwiY2hpbGRyZW4iLCJ1c2VTdGF0ZSIsInRva2VuIiwic2V0VG9rZW4iLCJ1c2VyIiwic2V0VXNlciIsInVzZUVmZmVjdCIsImNvbnNvbGUiLCJsb2ciLCJmZXRjaFVzZXIiLCJoYW5kbGVMb2dpbiIsImp3dCIsInNldCIsInBhdGgiLCJtYXhBZ2UiLCJzYW1lU2l0ZSIsImhhbmRsZUxvZ291dCIsInJlbW92ZSIsInVuZGVmaW5lZCIsImhhbmRsZVJlcXVlc3QiLCJyb3V0ZSIsIm9wdGlvbnMiLCJheGlvcyIsImdldCIsImhlYWRlcnMiLCJBdXRob3JpemF0aW9uIiwidGhlbiIsInJlc3BvbnNlIiwiZGF0YSIsImVycm9yIiwic3RhdHVzIiwiY29udGV4dCIsInVzZUF1dGgiLCJ1c2VDb250ZXh0Il0sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7QUFBQTtBQUNBO0FBQ0E7QUFFQSxJQUFNQSxXQUFXLGdCQUFHQywyREFBYSxFQUFqQztBQUNBLElBQU1DLE9BQU8sR0FBRyxJQUFJQyx3REFBSixFQUFoQjs7QUFFQSxJQUFNQyxZQUFZLEdBQUcsU0FBZkEsWUFBZSxPQUFrQjtBQUFBOztBQUFBLE1BQWZDLFFBQWUsUUFBZkEsUUFBZTs7QUFBQSxrQkFDWEMsc0RBQVEsRUFERztBQUFBLE1BQzlCQyxLQUQ4QjtBQUFBLE1BQ3ZCQyxRQUR1Qjs7QUFBQSxtQkFFYkYsc0RBQVEsRUFGSztBQUFBLE1BRTlCRyxJQUY4QjtBQUFBLE1BRXhCQyxPQUZ3Qjs7QUFJckNDLHlEQUFTLENBQUMsWUFBTTtBQUNkQyxXQUFPLENBQUNDLEdBQVIsQ0FBWU4sS0FBWjs7QUFDQSxRQUFJQSxLQUFKLEVBQVc7QUFDVE8sZUFBUztBQUNWO0FBQ0YsR0FMUSxFQUtOLEVBTE0sQ0FBVDs7QUFPQSxNQUFNQyxXQUFXLEdBQUcsU0FBZEEsV0FBYyxDQUFDQyxHQUFELEVBQVM7QUFDM0JkLFdBQU8sQ0FBQ2UsR0FBUixDQUFZLEtBQVosRUFBbUJELEdBQW5CLEVBQXdCO0FBQ3RCRSxVQUFJLEVBQUUsR0FEZ0I7QUFFdEJDLFlBQU0sRUFBRSxLQUFLLEVBQUwsR0FBVSxFQUFWLEdBQWUsRUFGRDtBQUVLO0FBQzNCQyxjQUFRLEVBQUU7QUFIWSxLQUF4QjtBQUtBWixZQUFRLENBQUNRLEdBQUQsQ0FBUjtBQUNELEdBUEQ7O0FBU0EsTUFBTUssWUFBWSxHQUFHLFNBQWZBLFlBQWUsR0FBTTtBQUN6Qm5CLFdBQU8sQ0FBQ29CLE1BQVIsQ0FBZSxLQUFmO0FBQ0FaLFdBQU8sQ0FBQ2EsU0FBRCxDQUFQO0FBQ0FmLFlBQVEsQ0FBQ2UsU0FBRCxDQUFSO0FBQ0QsR0FKRDs7QUFNQSxNQUFNQyxhQUFhLEdBQUcsU0FBaEJBLGFBQWdCLENBQUNDLEtBQUQsRUFBUUMsT0FBUixFQUFvQjtBQUN4QyxXQUFPQyw0Q0FBSyxDQUFDQyxHQUFOLGdDQUFrQ0gsS0FBbEM7QUFDTEksYUFBTyxFQUFFO0FBQ1BDLHFCQUFhLG1CQUFZdkIsS0FBWjtBQUROO0FBREosT0FJRm1CLE9BSkUsRUFBUDtBQU1ELEdBUEQ7O0FBU0EsTUFBTVosU0FBUyxHQUFHLFNBQVpBLFNBQVksR0FBTTtBQUN0QlUsaUJBQWEsQ0FBQyxPQUFELENBQWIsQ0FDR08sSUFESCxDQUNRLFVBQUNDLFFBQUQsRUFBYztBQUNsQnRCLGFBQU8sQ0FBQ3NCLFFBQVEsQ0FBQ0MsSUFBVixDQUFQO0FBQ0QsS0FISCxXQUlTLFVBQUNDLEtBQUQsRUFBVztBQUFBOztBQUNoQnRCLGFBQU8sQ0FBQ0MsR0FBUixDQUFZcUIsS0FBWjs7QUFDQSxVQUFJLENBQUFBLEtBQUssU0FBTCxJQUFBQSxLQUFLLFdBQUwsMkJBQUFBLEtBQUssQ0FBRUQsSUFBUCw0REFBYUUsTUFBYixLQUF1QixHQUEzQixFQUFnQztBQUM5QmQsb0JBQVk7QUFDYjtBQUNGLEtBVEg7QUFVRCxHQVhEOztBQWFBLE1BQU1lLE9BQU8sR0FBRztBQUNkN0IsU0FBSyxFQUFMQSxLQURjO0FBRWRFLFFBQUksRUFBSkEsSUFGYztBQUdkTSxlQUFXLEVBQVhBLFdBSGM7QUFJZE0sZ0JBQVksRUFBWkEsWUFKYztBQUtkRyxpQkFBYSxFQUFiQTtBQUxjLEdBQWhCO0FBUUEsc0JBQU8scUVBQUMsV0FBRCxDQUFhLFFBQWI7QUFBc0IsU0FBSyxFQUFFWSxPQUE3QjtBQUFBLGNBQXVDL0I7QUFBdkM7QUFBQTtBQUFBO0FBQUE7QUFBQSxXQUFQO0FBQ0QsQ0F6REQ7O0dBQU1ELFk7O0tBQUFBLFk7O0FBMkROLElBQU1pQyxPQUFPLEdBQUcsU0FBVkEsT0FBVTtBQUFBOztBQUFBLFNBQU1DLHdEQUFVLENBQUN0QyxXQUFELENBQWhCO0FBQUEsQ0FBaEI7O0lBQU1xQyxPOztBQUVOIiwiZmlsZSI6InN0YXRpYy93ZWJwYWNrL3BhZ2VzL2luZGV4LmMwOTdhNDI5OGVjMTdhZjNlMDAyLmhvdC11cGRhdGUuanMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQgeyB1c2VTdGF0ZSwgY3JlYXRlQ29udGV4dCwgdXNlQ29udGV4dCwgdXNlRWZmZWN0IH0gZnJvbSAncmVhY3QnXG5pbXBvcnQgQ29va2llcyBmcm9tICd1bml2ZXJzYWwtY29va2llJ1xuaW1wb3J0IGF4aW9zIGZyb20gJ2F4aW9zJ1xuXG5jb25zdCBBdXRoQ29udGV4dCA9IGNyZWF0ZUNvbnRleHQoKVxuY29uc3QgY29va2llcyA9IG5ldyBDb29raWVzKClcblxuY29uc3QgQXV0aFByb3ZpZGVyID0gKHsgY2hpbGRyZW4gfSkgPT4ge1xuICBjb25zdCBbdG9rZW4sIHNldFRva2VuXSA9IHVzZVN0YXRlKClcbiAgY29uc3QgW3VzZXIsIHNldFVzZXJdID0gdXNlU3RhdGUoKVxuXG4gIHVzZUVmZmVjdCgoKSA9PiB7XG4gICAgY29uc29sZS5sb2codG9rZW4pXG4gICAgaWYgKHRva2VuKSB7XG4gICAgICBmZXRjaFVzZXIoKVxuICAgIH1cbiAgfSwgW10pXG5cbiAgY29uc3QgaGFuZGxlTG9naW4gPSAoand0KSA9PiB7XG4gICAgY29va2llcy5zZXQoJ2p3dCcsIGp3dCwge1xuICAgICAgcGF0aDogJy8nLFxuICAgICAgbWF4QWdlOiA2MCAqIDYwICogMjQgKiAzMCwgLy8gMzAgZGF5c1xuICAgICAgc2FtZVNpdGU6ICdsYXgnLFxuICAgIH0pXG4gICAgc2V0VG9rZW4oand0KVxuICB9XG5cbiAgY29uc3QgaGFuZGxlTG9nb3V0ID0gKCkgPT4ge1xuICAgIGNvb2tpZXMucmVtb3ZlKCdqd3QnKVxuICAgIHNldFVzZXIodW5kZWZpbmVkKVxuICAgIHNldFRva2VuKHVuZGVmaW5lZClcbiAgfVxuXG4gIGNvbnN0IGhhbmRsZVJlcXVlc3QgPSAocm91dGUsIG9wdGlvbnMpID0+IHtcbiAgICByZXR1cm4gYXhpb3MuZ2V0KGBodHRwOi8vbG9jYWxob3N0OjgwODAke3JvdXRlfWAsIHtcbiAgICAgIGhlYWRlcnM6IHtcbiAgICAgICAgQXV0aG9yaXphdGlvbjogYEJlYXJlciAke3Rva2VufWAsXG4gICAgICB9LFxuICAgICAgLi4ub3B0aW9ucyxcbiAgICB9KVxuICB9XG5cbiAgY29uc3QgZmV0Y2hVc2VyID0gKCkgPT4ge1xuICAgIGhhbmRsZVJlcXVlc3QoJy91c2VyJylcbiAgICAgIC50aGVuKChyZXNwb25zZSkgPT4ge1xuICAgICAgICBzZXRVc2VyKHJlc3BvbnNlLmRhdGEpXG4gICAgICB9KVxuICAgICAgLmNhdGNoKChlcnJvcikgPT4ge1xuICAgICAgICBjb25zb2xlLmxvZyhlcnJvcilcbiAgICAgICAgaWYgKGVycm9yPy5kYXRhPy5zdGF0dXMgPj0gNDAwKSB7XG4gICAgICAgICAgaGFuZGxlTG9nb3V0KClcbiAgICAgICAgfVxuICAgICAgfSlcbiAgfVxuXG4gIGNvbnN0IGNvbnRleHQgPSB7XG4gICAgdG9rZW4sXG4gICAgdXNlcixcbiAgICBoYW5kbGVMb2dpbixcbiAgICBoYW5kbGVMb2dvdXQsXG4gICAgaGFuZGxlUmVxdWVzdCxcbiAgfVxuXG4gIHJldHVybiA8QXV0aENvbnRleHQuUHJvdmlkZXIgdmFsdWU9e2NvbnRleHR9PntjaGlsZHJlbn08L0F1dGhDb250ZXh0LlByb3ZpZGVyPlxufVxuXG5jb25zdCB1c2VBdXRoID0gKCkgPT4gdXNlQ29udGV4dChBdXRoQ29udGV4dClcblxuZXhwb3J0IHsgQXV0aFByb3ZpZGVyLCB1c2VBdXRoIH1cbiJdLCJzb3VyY2VSb290IjoiIn0=